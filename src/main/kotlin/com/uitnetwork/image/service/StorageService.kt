package com.uitnetwork.image.service

import com.google.cloud.storage.Bucket
import com.google.cloud.storage.Bucket.BlobWriteOption.predefinedAcl
import com.google.cloud.storage.Storage.PredefinedAcl.PUBLIC_READ
import com.uitnetwork.image.model.StorageType
import com.uitnetwork.image.properties.GoogleStorageProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.util.UriComponentsBuilder
import java.io.InputStream

@Service
class StorageService {

    @Autowired
    private lateinit var bucket: Bucket

    @Autowired
    private lateinit var storageNameService: StorageNameService

    @Autowired
    private lateinit var googleStorageProperties: GoogleStorageProperties

    fun uploadForPublicRead(inputStream: InputStream, storageType: StorageType): String {
        val randomName = storageNameService.generateRandomName()
        val blobName = randomName + storageType.extension
        bucket.create(blobName, inputStream, storageType.contentType, predefinedAcl(PUBLIC_READ))


        val publicUrl = UriComponentsBuilder.fromHttpUrl(googleStorageProperties.publicLink)
                .path("/${googleStorageProperties.bucketName}")
                .path("/$blobName")
                .build().toString()

        return publicUrl
    }
}
