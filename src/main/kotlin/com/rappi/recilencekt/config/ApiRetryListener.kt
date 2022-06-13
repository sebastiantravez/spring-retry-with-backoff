package com.rappi.recilencekt.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.listener.RetryListenerSupport


class ApiRetryListener : RetryListenerSupport() {

    private val LOGGER: Logger = LoggerFactory.getLogger(ApiRetryListener::class.java)

    override fun <T, E : Throwable?> open(context: RetryContext?, callback: RetryCallback<T, E>?): Boolean {
        LOGGER.info("ApiRetryListener.open")
        return super.open(context, callback)
    }

    override fun <T, E : Throwable?> onError(
        context: RetryContext?, callback: RetryCallback<T, E>?, throwable: Throwable?
    ) {
        LOGGER.info("ApiRetryListener.onError")
    }

    override fun <T, E : Throwable?> close(context: RetryContext?, callback: RetryCallback<T, E>?, throwable: Throwable?) {
        LOGGER.info("ApiRetryListener.close")
        LOGGER.info("ApiRetryListener.onError isExhausted {}", context?.let { isExhausted(it) })
    }

    private fun isExhausted(context: RetryContext?): Boolean {
        return context!!.hasAttribute(RetryContext.EXHAUSTED)
    }

    private fun isClosed(context: RetryContext?): Boolean {
        return context!!.hasAttribute(RetryContext.CLOSED)
    }

    private fun isRecovered(context: RetryContext?): Boolean {
        return context!!.hasAttribute(RetryContext.RECOVERED)
    }

}
