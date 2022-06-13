package com.rappi.recilencekt.controller

import com.rappi.recilencekt.service.RetryServiceImpl
import com.rappi.recilencekt.service.RetryTemplateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class RetryController(
    private val retryService: RetryServiceImpl, private val retryTemplateService: RetryTemplateService
) {

    @GetMapping("/api/{msg}")
    fun callService(@PathVariable("msg") msg: String): ResponseEntity<String>? {
        return ResponseEntity.ok(retryService.retryService(msg))
    }

    @GetMapping("/api/template/{msg}")
    fun callTemplateService(@PathVariable("msg") msg: String): ResponseEntity<String?> {
        return ResponseEntity.ok(retryTemplateService.retryTemplateExample(msg))
    }
}