package com.tootest.ch.user

import com.tootest.ch.user.dto.UserResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import khttp.get as httpGet

@RestController
class UserController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/user")
    fun user(@RequestParam email: String, @RequestHeader headers: Map<String, String>) : UserResponse {
        logger.info("Request Headers:{}", headers.entries.joinToString { it.key + ":" + it.value })
        logger.info("[UserInfo] Retrieving user info: email={}", email)
        if (email.startsWith("too")) {
            try {
                checkEmailExists(email)
            } catch (e: EmailNotfoundException) {
                logger.error("[UserInfo] Get user failed.", e)
                throw e
            }

            httpGet("https://ee1534bcdb2b.ngrok.io/weatherforecast")


        }
        val userInfo =  UserResponse( email, "Name1", "lastName1")
        logger.info("[UserInfo] User Info:{}", userInfo)

        return userInfo
    }

    fun checkEmailExists(email: String) {
        if (email.startsWith("too")) {
            throw EmailNotfoundException("The specified email:${email} is not found.");
        }
    }


    class EmailNotfoundException(s: String) : Exception(s)


}