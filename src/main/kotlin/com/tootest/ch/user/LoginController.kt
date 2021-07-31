package com.tootest.ch.user

import com.tootest.ch.user.dto.UserLoginRequest
import com.tootest.ch.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController(userRepository: UserRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    val userRepository = userRepository;

    @PostMapping("/login")
    fun login(@RequestBody userLogin: UserLoginRequest): ResponseEntity<String> {
        logger.info("[Login] userName: {}", userLogin.email)
        val user = userRepository.findUserByEmail(userLogin.email)

        return if (user == null) {

            ResponseEntity("", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity(user.email,HttpStatus.OK)
        }

    }
}