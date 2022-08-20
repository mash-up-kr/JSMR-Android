package com.marryting.app.data.profile.model

data class Questionnaire(
    val questionId: Long,
    val question: String,
    val answer1: String,
    val answer2: String
)

data class QuestionnaireResponse(
    val data: List<Questionnaire>,
    val status: Int
)

data class QuestionnaireResult(
    val questionId: Long,
    val answer: String
)
