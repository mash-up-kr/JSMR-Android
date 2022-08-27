package com.marryting.app.presentation.profile.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marryting.app.component.MarrytingKeyword
import com.marryting.app.data.profile.model.Keyword
import com.ui.theme.Color

@Composable
fun KeywordScreen(
    modifier: Modifier = Modifier,
    keywordList: List<Keyword>,
    getProfileInfoKeywords: List<Keyword>?,
    addProfileInfoKeywords: (Keyword) -> Unit,
    removeProfileInfoKeyword: (Keyword) -> Unit
) {
    Surface(
        color = Color.DarkBackground,
        modifier = modifier.padding(top = 40.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var count = 2
            var startIndex = 0
            val keywordListSize = keywordList.size

            while (startIndex < keywordListSize) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    keywordList.subList(startIndex, startIndex + count).forEach { keyword ->
                        MarrytingKeyword(
                            value = keyword,
                            selectedItemList = getProfileInfoKeywords ?: emptyList(),
                            onSelected = { addProfileInfoKeywords(it) },
                            onCanceled = { removeProfileInfoKeyword(it) }
                        )
                    }
                }
                startIndex += count
                count = if (keywordListSize - startIndex < count) {
                    keywordListSize - startIndex
                } else if (count == 2) {
                    3
                } else {
                    2
                }
            }

        }
    }
}
