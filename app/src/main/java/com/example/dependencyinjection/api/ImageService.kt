package com.example.dependencyinjection.api

import com.example.dependencyinjection.utils.Constants.CLIENT_ID
import com.example.dependencyinjection.utils.Constants.END_POINT
import com.example.dependencyinjection.model.ImageItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET(END_POINT)
    suspend fun getAllImages(): Response<List<ImageItem>>
}