package com.marryting.app.data.picture.model

import okhttp3.MultipartBody

data class PictureRequest(
    val fileSize: String,
    val images: List<MultipartBody.Part>
)

data class PictureResponse(
    val data: List<String>,
    val status: Int
)
