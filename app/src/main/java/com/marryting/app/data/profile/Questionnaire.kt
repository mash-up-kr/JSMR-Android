package com.marryting.app.data.profile

data class Questionnaire(
    val id: Long,
    val question: String,
    val answer1: String,
    val answer2: String
)

data class QuestionnaireResponse(
    val data: List<Questionnaire>,
    val status: Int
)

data class QuestionnaireRequest(
    val questionId: Long,
    val answer: String
)
