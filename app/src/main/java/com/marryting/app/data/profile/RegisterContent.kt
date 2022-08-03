package com.marryting.app.data.profile

data class RegisterContent(
    val id: Int,
    val title: List<String>,
    val description: String,
    val contentViewType: ContentViewType? = null
)

sealed interface ContentViewType {
    object UserInfoInputs : ContentViewType
    object Pictures : ContentViewType
    object Keywords : ContentViewType
    object Questions : ContentViewType
}
