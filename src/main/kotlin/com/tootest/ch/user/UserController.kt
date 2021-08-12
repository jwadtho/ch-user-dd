package com.tootest.ch.user

import com.tootest.ch.user.dto.UserResponse
import com.tootest.ch.user.entity.User
import com.tootest.ch.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import khttp.get as httpGet

@RestController
class UserController {


    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private val userRepository: UserRepository? = null

    @Value("\${tootest-dotnet.endpoint}")
    val dotnetEndpoint: String? = null


    @GetMapping("/user")
    fun user(@RequestParam email: String, @RequestHeader headers: Map<String, String>) : UserResponse {
        logger.info("Request Headers:{}", headers.entries.joinToString { it.key + ":" + it.value })
        logger.info("[UserInfo] Retrieving user info: email={}", email)
        val user: User
        try {
            user = checkEmailExists(email)
        } catch (e: EmailNotfoundException) {
            logger.error("[UserInfo] Get email failed.", e)
            throw e
        }
        val userInfo =  UserResponse( email, user.name, "lastNameTest")
        logger.info("[UserInfo] User Info:{}", userInfo)

        logger.info("[UserInfo] Getting user from db");
        val users = userRepository!!.findAll()
        logger.info("[UserInfo] Getting user[0] from db: {}", users.first());

        val forecastUrl = "${dotnetEndpoint}/weatherforecast";
        logger.info("[UserInfo] Calling forecast api:{}", forecastUrl)
        val forecast = httpGet(url = forecastUrl, headers = mapOf("APPCODE" to "6caea7ebc9a646a4981d7ce0d9dceae4"))
        logger.info("[UserInfo] Response from forecast api: status:${forecast.statusCode}, text:${forecast.text}")

        return userInfo
    }

    fun checkEmailExists(email: String): User {
        val user = userRepository?.findUserByEmail(email)
            ?: throw EmailNotfoundException("The specified email:${email} is not found.");
        return user;
    }


    class EmailNotfoundException(s: String) : Exception(s)


}