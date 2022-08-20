package com.marryting.app.data.profile.model

data class Keyword(
    val keywordId: Long,
    val keyword: String
)

data class KeywordResponse(
    val data: List<Keyword>,
    val status: Int
)
