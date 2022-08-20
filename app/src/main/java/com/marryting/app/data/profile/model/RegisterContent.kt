package com.marryting.app.data.profile.model

data class RegisterContent(
    val id: Int,
    val title: List<String>,
    val description: String,
    val contentViewType: ContentViewType? = null
)

sealed interface ContentViewType {
    object UserInfo : ContentViewType
    object Picture : ContentViewType
    object Keyword : ContentViewType
    object Questionnaire : ContentViewType
}
