package com.tootest.ch.user.repository

import com.tootest.ch.user.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User?, Int?> {

    fun findUserByEmail(email: String) : User?
}

