package com.tootest.ch.user

import com.tootest.ch.user.entity.User
import com.tootest.ch.user.repository.UserRepository
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(path = ["/demo"])
class ChUserController(userRepository: UserRepository) {
    private val userRepository = userRepository

    @PostMapping(path = ["/add"])
    @ResponseBody
    fun addNewUser(
        @RequestParam @NotNull name: String, @RequestParam @NotNull email: String
    ): String {
        val n = User(name = name, email = email)
        userRepository.save(n)
        return "Saved"
    }

    @get:ResponseBody
    @get:GetMapping(path = ["/all"])
    val allUsers: Iterable<User?>
        get() =// This returns a JSON or XML with the users
            userRepository!!.findAll()
}