package com.uitnetwork.image.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    private val logger = LoggerFactory.getLogger(HealthCheckController::class.java)

    @ResponseStatus(OK)
    @GetMapping("/_ah/health")
    fun healthCheck() {
        logger.info("Health OK.")
    }

    @ResponseStatus(OK)
    @GetMapping("/")
    fun healthCheck2() {
        logger.info("Health 2 OK.")
    }
}
