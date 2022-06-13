package com.rappi.recilencekt.controller

import com.rappi.recilencekt.service.RetryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class RetryController(private val retryService: RetryService) {

    @GetMapping("/api/{msg}")
    fun callService(@PathVariable("msg") msg: String?): ResponseEntity<String>? {
        return ResponseEntity.ok(retryService.retryService(msg))
    }

}