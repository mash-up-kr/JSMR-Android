package com.marryting.app.data.profile

data class Content(
    val id: Int,
    val title: List<String>,
    val description: String,
    val contentViewType: ContentViewType? = null
)

sealed interface ContentViewType {
    object Inputs : ContentViewType
    object Pictures : ContentViewType
    object Keywords : ContentViewType
    object Answers: ContentViewType
}
