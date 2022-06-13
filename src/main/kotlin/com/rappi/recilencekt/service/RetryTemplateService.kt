package com.rappi.recilencekt.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.retry.RetryCallback
import org.springframework.retry.annotation.Recover
import org.springframework.retry.support.RetryTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RetryTemplateService {
    private val log: Logger = LoggerFactory.getLogger(RetryTemplateService::class.java)
    private var retryTemplate: RetryTemplate? = null

    @Autowired
    fun RetryTemplateService(retryTemplate: RetryTemplate?) {
        this.retryTemplate = retryTemplate
    }

    fun retryTemplateExample(msg: String): String? {
        val result = retryTemplate?.execute<String?, RuntimeException?> {
            log.info(String.format("Reitentando retryTemplateExample %d", LocalDateTime.now().second))
            if (msg == "error") {
                throw RuntimeException("Error en proceso")
            } else {
                "Hola $msg"
            }
        }
        log.info("Retornando {}", result)
        return result
    }

}