package com.marryting.app.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    currentContentIndex: Int,
    totalContentsCount: Int
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        for (i in 0 until totalContentsCount) {
            val backgroundColor = if (i <= currentContentIndex) {
                Color.White
            } else {
                Color.Transparent
            }

            Box(
                modifier = modifier
                    .size(8.dp)
                    .background(backgroundColor, CircleShape)
                    .then(
                        if (currentContentIndex < i) {
                            Modifier.border(1.dp, Color.White, CircleShape)
                        } else {
                            Modifier
                        }
                    )
            )
            Spacer(modifier = Modifier.padding(end = 6.dp))
        }
    }
}
