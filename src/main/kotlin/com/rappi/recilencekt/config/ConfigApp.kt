package com.rappi.recilencekt.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.support.RetryTemplate

@Configuration
class ConfigApp {
    @Bean
    fun retryTemplate(): RetryTemplate? {
        return RetryTemplate.builder()
            .maxAttempts(4)
            .fixedBackoff(1000L)
            .retryOn(RuntimeException::class.java)
            .withListener(ApiRetryListener())
            .build()
    }
}