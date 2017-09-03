package com.uitnetwork.image.model

import com.uitnetwork.image.exception.StorageTypeException

enum class StorageType(val contentType: String, val extension: String) {
    IMAGE_PNG("image/png", ".png"),
    IMAGE_JPEG("image/jpeg", ".jpg");

    companion object {
        private val storageTypeMap = StorageType.values().associateBy(StorageType::contentType)

        fun getStorageType(contentType: String): StorageType {
            val storageType = storageTypeMap.get(contentType) ?: throw StorageTypeException("ContentType: $contentType is not supported.")

            return storageType
        }
    }
}

