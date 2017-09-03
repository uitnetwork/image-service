package com.uitnetwork.image.config

import com.google.cloud.storage.Bucket
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import com.uitnetwork.image.properties.GoogleStorageProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GoogleStorageConfig {
    private val logger = LoggerFactory.getLogger(GoogleStorageConfig::class.java)

    @Autowired
    private lateinit var googleStorageProperties: GoogleStorageProperties

    @Bean
    fun storage(): Storage {
        return StorageOptions.getDefaultInstance().service;
    }

    @Bean
    fun imageServiceBucket(): Bucket {
        logger.info("GoogleStorageProperties is: {}", googleStorageProperties)

        return storage().get(googleStorageProperties.bucketName)
    }
}
