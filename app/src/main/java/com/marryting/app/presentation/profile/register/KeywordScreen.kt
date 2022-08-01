package com.marryting.app.presentation.profile.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marryting.app.component.MarrytingKeyword
import com.ui.theme.Color

@Composable
fun KeywordScreen(modifier: Modifier = Modifier) {
    Surface(
        color = Color.DarkBackground,
        modifier = modifier.padding(top = 40.dp)
    ) {
        var selectedItemList by remember { mutableStateOf(listOf<String>()) }

        val items = listOf(
            "따듯한", "유머있는", "다정한", "편안한", "친절한",
            "낙천적인", "열정적인", "성실한", "신중한", "매력있는",
            "지적인", "애교있는", "차분한", "논리적인", "침착한",
            "조용한", "진지한", "친근한", "활동적인", "명량한"
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var count = 2
            var startIndex = 0
            val itemsSize = items.size

            while (startIndex < itemsSize) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items.subList(startIndex, startIndex + count).forEach { keyword ->
                        MarrytingKeyword(
                            value = keyword,
                            selectedItemList = selectedItemList,
                            onSelected = { item ->
                                if (selectedItemList.size < 5) {
                                    selectedItemList = selectedItemList + item
                                }
                            },
                            onCanceled = { item ->
                                selectedItemList = selectedItemList.toMutableList().also { it.remove(item) }
                            }
                        )
                    }
                }
                startIndex += count
                count = if (itemsSize - startIndex < count) itemsSize - startIndex else if (count == 2) 3 else 2
            }
        }
    }
}
