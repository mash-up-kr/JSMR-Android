package com.marryting.app.presentation.profile.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marryting.app.component.MarrytingRadioGroup
import com.marryting.app.data.profile.model.Questionnaire
import com.ui.theme.Color
import com.ui.theme.DarkColor
import com.ui.theme.KoreaTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionnaireScreen(modifier: Modifier = Modifier, questionnaireList: List<Questionnaire>, getProfileInfoAnswersById: (Long) -> String, setProfileInfoAnswers: (Long, String) -> Unit) {
    Surface(
        color = Color.DarkBackground,
        modifier = modifier.padding(top = 40.dp, start = 32.dp, end = 32.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(bottom = 148.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(
                items = questionnaireList
            ) { index, questionnaire ->
                Column {
                    Text(
                        modifier = Modifier.padding(bottom = 2.dp),
                        text = questionnaire.question,
                        style = KoreaTypography.body2,
                        color = DarkColor.Grey100
                    )
                    MarrytingRadioGroup(
                        items = listOf(questionnaire.answer1, questionnaire.answer2),
                        selectedItem = getProfileInfoAnswersById(questionnaire.questionId),
                        itemSelected = { setProfileInfoAnswers(index + 1L, it) }
                    )
                }
            }
        }
    }
}
