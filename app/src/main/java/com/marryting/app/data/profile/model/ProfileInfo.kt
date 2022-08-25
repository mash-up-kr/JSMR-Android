package com.marryting.app.data.profile.model

import java.util.*

data class ProfileInfo(
    val name: String? = null,
    val gender: String? = null,
    val career: String? = null,
    val birth: Date? = null,
    val address: String? = null,
    val pictures: List<String> = emptyList(),
    val keywords: List<Keyword> = emptyList(),
    val answers: List<QuestionnaireResult> = emptyList()
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
