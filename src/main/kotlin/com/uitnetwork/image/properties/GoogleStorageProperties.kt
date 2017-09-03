package com.uitnetwork.image.properties

import com.uitnetwork.image.annotation.NoArg
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "storage.google")
@NoArg
data class GoogleStorageProperties(
        var publicLink: String,
        var bucketName: String
)
