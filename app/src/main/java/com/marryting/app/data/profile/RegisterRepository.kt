package com.marryting.app.data.profile

class RegisterRepository {

    fun getRegisterContents(): List<RegisterContent> = listOf(
        RegisterContent(
            id = 0,
            title = listOf("당신의 ", "기본정보", "를\n알려주세요"),
            description = "곧 만날 상대에게 이렇게 소개할게요",
            contentViewType = ContentViewType.UserInfoInputs
        ),
        RegisterContent(
            id = 1,
            title = listOf("당신의 ", "매력적인", " 모습을\n보여주세요"),
            description = "2장 이상의 다양한 모습을 보고싶어요",
            contentViewType = ContentViewType.Pictures
        ),
        RegisterContent(
            id = 2,
            title = listOf("당신을 ", "키워드", "로\n표현해보세요"),
            description = "5개의 키워드로 당신을 알려주세요",
            contentViewType = ContentViewType.Keywords
        ),
        RegisterContent(
            id = 3,
            title = listOf("내가 쓰는\n나의 ", "성향", " 소개서"),
            description = "꼭 기억해서 맞춤 추천해드릴게요",
            contentViewType = ContentViewType.Questions
        )
    )
}
