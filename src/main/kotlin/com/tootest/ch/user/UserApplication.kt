package com.tootest.ch.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import java.net.InetAddress

@SpringBootApplication
class UserApplication

fun main(args: Array<String>) {
	runApplication<UserApplication>(*args)
	val localhost = InetAddress.getLocalHost()
	println("[UserInfo] Hostname:${localhost.hostName}, HostAddress: ${localhost.hostAddress}, CanonicalHostName: ${localhost.canonicalHostName}")
}