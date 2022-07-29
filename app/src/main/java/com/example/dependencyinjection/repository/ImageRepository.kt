package com.example.dependencyinjection.repository

import com.example.dependencyinjection.api.ImageService
import javax.inject.Inject

class ImageRepository @Inject constructor(private val api: ImageService) {
    suspend fun getAllImage() = api.getAllImages()
}