package com.marryting.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marryting.app.R
import com.ui.theme.Color
import com.ui.theme.DarkColor

@ExperimentalMaterial3Api
@Composable
fun MarrytingRadioGroup(modifier: Modifier = Modifier, items: List<String> = emptyList(), selectedItem: String, itemSelected: (String) -> Unit) {
    Column {
        items.forEach { item ->

            val selectedBorderColor = if (selectedItem == item) {
                DarkColor.SubGreen
            } else {
                DarkColor.Grey600
            }

            val backgroundColor = if (selectedItem == item) {
                DarkColor.SubGreen.copy(alpha = 0.16f)
            } else {
                DarkColor.Grey800
            }

            Box(
                modifier = modifier
                    .width(296.dp)
                    .padding(top = 6.dp)
                    .border(1.dp, selectedBorderColor, RoundedCornerShape(8.dp))
                    .background(backgroundColor, RoundedCornerShape(8.dp))
                    .selectable(
                        enabled = true,
                        selected = item == selectedItem,
                        role = Role.RadioButton,
                        onClick = {
                            itemSelected(item)
                        }
                    )
            ) {
                Row(modifier = Modifier.padding(20.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_radio_check_disabled),
                        tint = if (selectedItem == item) {
                            DarkColor.SubGreen
                        } else {
                            DarkColor.Grey400
                        },
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = item,
                        color = when (selectedItem) {
                            item -> {
                                Color.White
                            }
                            "" -> {
                                DarkColor.Grey100
                            }
                            else -> {
                                DarkColor.Grey200
                            }
                        },
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = if (selectedItem == item) {
                            FontWeight.Bold
                        } else {
                            FontWeight.Normal
                        }
                    )
                }
            }
        }
    }
}
