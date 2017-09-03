package com.uitnetwork.image.config

import com.google.cloud.datastore.Datastore
import com.google.cloud.datastore.DatastoreOptions
import com.google.cloud.datastore.KeyFactory
import com.uitnetwork.image.properties.GoogleStorageProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GoogleDatastoreConfig {
    private val logger = LoggerFactory.getLogger(GoogleDatastoreConfig::class.java)

    companion object {
        const val IMAGE_TYPE = "IMG"
    }

    @Autowired
    private lateinit var googleStorageProperties: GoogleStorageProperties

    @Bean
    fun datastore(): Datastore {
        return DatastoreOptions.getDefaultInstance().service;
    }

    @Bean
    fun keyFactory(): KeyFactory {
        return datastore().newKeyFactory().setKind(IMAGE_TYPE)
    }
}
