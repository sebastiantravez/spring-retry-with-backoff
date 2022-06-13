package com.rappi.recilencekt.service

interface RetryService {
    @Throws(RuntimeException::class)
    fun retryService(s: String?): String?
    fun retryExampleRecovery(t: RuntimeException?, s: String?): String?
}