package com.uitnetwork.image.service

import com.google.cloud.Timestamp
import com.google.cloud.datastore.Datastore
import com.google.cloud.datastore.Entity
import com.google.cloud.datastore.KeyFactory
import com.uitnetwork.image.model.StorageType
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class ImageService {
    private val logger = LoggerFactory.getLogger(ImageService::class.java)

    @Autowired
    private lateinit var storageService: StorageService

    @Autowired
    private lateinit var datastore: Datastore

    @Autowired
    private lateinit var keyFactory: KeyFactory

    fun uploadImage(inputStream: InputStream): String {
        val imageUrl = storageService.uploadForPublicRead(inputStream, StorageType.IMAGE_PNG)

        val allocatedKey = datastore.allocateId(keyFactory.newKey())

        val entity = Entity.newBuilder(allocatedKey)
                .set("url", imageUrl)
                .set("created", Timestamp.now())
                .build()
        datastore.put(entity)

        return allocatedKey.id.toString()
    }

}
