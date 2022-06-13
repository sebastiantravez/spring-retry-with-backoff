package com.rappi.recilencekt.service.impl

import com.rappi.recilencekt.service.RetryService
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class RetryServiceImpl : RetryService {

    private var attempts = 1

    @Retryable(value = [RuntimeException::class], maxAttempts = 4, backoff = Backoff(2000))
    @Throws(RuntimeException::class)
    override fun retryService(s: String?): String? {
        println("Intento # " + attempts++ + " " + Instant.now())
        if (s == "error") {
            throw RuntimeException("Error llamando a retryService ")
        }
        println("Acción realizada")
        return "OK"
    }

    @Recover
    override fun retryExampleRecovery(t: RuntimeException?, s: String?): String? {
        if (t != null) {
            println(String.format("Recuperando a - %s", t.message))
        }
        println("Recuperada la llamada al servicio que falla")
        return "OK (Recuperado)"
    }

}