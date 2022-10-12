package com.rappi.recilencekt.service

import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.retry.support.RetryTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class RetryTemplateService {
    private val log: Logger = LoggerFactory.getLogger(RetryTemplateService::class.java)
    @Autowired
    private lateinit var retryTemplate: RetryTemplate

    fun retryTemplateExample(s: String): String? {
        var result = retryTemplate.execute<String, RuntimeException> { // do something in this service
            log.info(String.format("Ejecutando retry %d", LocalDateTime.now().second))
            if (s == "error") {
                throw RuntimeException("Error en proceso")
            } else {
                "Hi $s"
            }
        }
        log.info("Retornando {}", result)
        return result
    }

}