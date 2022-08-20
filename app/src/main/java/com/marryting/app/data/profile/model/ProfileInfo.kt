package com.marryting.app.data.profile.model

import java.util.*

data class ProfileInfo(
    val name: String,
    val gender: String,
    val career: String,
    val birth: Date,
    val address: String,
    val pictures: List<String>,
    val keywords: List<Keyword>,
    val answers: List<QuestionnaireResult>
)

data class ProfileRequest(
    val oauthType: String,
    val profile: ProfileInfo,
    val thirdPartyToken: String
)

data class ProfileToken(
    val accessToken: String,
    val status: Int
)

data class ProfileResponse(
    val data: ProfileToken,
    val status: Int
)
