package com.uitnetwork.image.controller

import com.uitnetwork.image.service.ImageService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/image")
class ImageController {
    private val logger = LoggerFactory.getLogger(ImageController::class.java)

    @Autowired
    private lateinit var imageService: ImageService

    @PostMapping(consumes = arrayOf("multipart/*"), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun uploadImage(@RequestParam("file") file: MultipartFile): String {
        logger.debug("Received request to upload image: {} with contentType: {}", file, file.contentType)

        return imageService.uploadImage(file.inputStream)
    }
}
