package com.marryting.app.presentation.profile.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.marryting.app.component.MarrytingDropdown
import com.marryting.app.component.MarrytingTextField
import com.ui.theme.DarkColor
import java.util.*

@Composable
fun UserInfoScreen(modifier: Modifier = Modifier, getProfileInfoName: String?, setProfileInfoName: (String) -> Unit, getProfileInfoGender: String?, setProfileInfoGender: (String) -> Unit, getProfileInfoBirth: Date?, setProfileInfoBirth: (Date) -> Unit, getProfileInfoAddress: String?, setProfileInfoAddress: (String) -> Unit, getProfileInfoCareer: String?, setProfileInfoCareer: (String) -> Unit) {
    var nameState by remember { mutableStateOf(UserInfoItemState.BASIC) }
    var genderState by remember { mutableStateOf(UserInfoItemState.BASIC) }
    var birthState by remember { mutableStateOf(UserInfoItemState.BASIC) }
    var addressState by remember { mutableStateOf(UserInfoItemState.BASIC) }
    var careerState by remember { mutableStateOf(UserInfoItemState.BASIC) }

    Surface(
        color = com.ui.theme.Color.DarkBackground,
        modifier = modifier.padding(top = 40.dp, start = 32.dp, end = 32.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                MarrytingTextField(
                    modifier = Modifier.onFocusChanged { focusState ->
                        nameState = if (focusState.isFocused) {
                            UserInfoItemState.ACTIVE
                        } else {
                            UserInfoItemState.BASIC
                        }
                    },
                    value = getProfileInfoName ?: "",
                    onValueChanged = {
                        nameState = if (it.length >= 5) {
                            UserInfoItemState.ERROR
                        } else {
                            UserInfoItemState.ACTIVE
                        }
                        setProfileInfoName(it)
                    },
                    onValueClear = { setProfileInfoName("") },
                    state = nameState,
                    label = "이름",
                    placeholder = "ex) 박우인"
                )
            }

            item {
                MarrytingDropdown(
                    modifier = Modifier.onFocusChanged { focusState ->
                        genderState = if (focusState.isFocused) {
                            UserInfoItemState.ACTIVE
                        } else {
                            UserInfoItemState.BASIC
                        }
                    },
                    value = getProfileInfoGender ?: "",
                    onValueChanged = { setProfileInfoGender(it) },
                    state = genderState,
                    label = "성별",
                    placeholder = "성별을 선택해주세요"
                )
            }

//            item {
//                MarrytingDatePicker(
//                    value = birth,
//                    onValueChanged = { birth = it },
//                    state = birthState,
//                    label = "생년월일",
//                    placeholder = "생년월일을 선택해주세요"
//                )
//            }

            item {
                MarrytingTextField(
                    modifier = Modifier.onFocusChanged { focusState ->
                        addressState = if (focusState.isFocused) {
                            UserInfoItemState.ACTIVE
                        } else {
                            UserInfoItemState.BASIC
                        }
                    },
                    value = getProfileInfoAddress ?: "",
                    onValueChanged = {
                        addressState = if (it.length >= 10) {
                            UserInfoItemState.ERROR
                        } else {
                            UserInfoItemState.ACTIVE
                        }
                        setProfileInfoAddress(it)
                    },
                    onValueClear = { setProfileInfoAddress("") },
                    state = addressState,
                    label = "사는 곳",
                    placeholder = "ex) 서울시 광진구"
                )
            }

            item {
                MarrytingTextField(
                    modifier = Modifier.onFocusChanged { focusState ->
                        careerState = if (focusState.isFocused) {
                            UserInfoItemState.ACTIVE
                        } else {
                            UserInfoItemState.BASIC
                        }
                    },
                    value = getProfileInfoCareer ?: "",
                    onValueChanged = {
                        careerState = if (it.length >= 10) {
                            UserInfoItemState.ERROR
                        } else {
                            UserInfoItemState.ACTIVE
                        }
                        setProfileInfoCareer(it)
                    },
                    onValueClear = { setProfileInfoCareer("") },
                    state = careerState,
                    label = "직업",
                    placeholder = "ex) IT 기획자"
                )
            }
        }
    }
}

enum class UserInfoItemState(val color: Color) {
    ACTIVE(DarkColor.SubGreen),
    ERROR(DarkColor.ErrorRed),
    BASIC(DarkColor.Grey400)
}
