package com.uitnetwork.image.service

import org.springframework.stereotype.Service
import java.time.LocalDate.now
import java.time.ZoneOffset.UTC
import java.util.*

@Service
class StorageNameService {

    fun generateRandomName(): String {
        val currentLocalDateInUtc = now(UTC)
        val randomName = UUID.randomUUID().toString()

        return "${currentLocalDateInUtc.toString()}/$randomName"
    }
}
