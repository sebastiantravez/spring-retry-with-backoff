package com.rappi.recilencekt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class RecilencektApplication

fun main(args: Array<String>) {
	runApplication<RecilencektApplication>(*args)
}
