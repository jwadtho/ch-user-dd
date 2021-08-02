package com.tootest.ch.user.configuration

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty


@ConditionalOnProperty(prefix = "jaeger", name = ["enabled"], havingValue = "true")
annotation class OnJaeger