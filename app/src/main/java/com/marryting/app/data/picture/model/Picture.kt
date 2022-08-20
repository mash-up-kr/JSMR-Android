package com.marryting.app.data.picture.model

import okhttp3.MultipartBody

data class PictureRequest(
    val image: MultipartBody.Part
)

data class PictureResponse(
    val data: List<String>,
    val status: Int
)
