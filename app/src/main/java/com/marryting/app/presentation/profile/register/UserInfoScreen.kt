package com.marryting.app.presentation.profile.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.marryting.app.component.MarrytingTextField
import com.marryting.app.presentation.profile.UserInfoTextFieldState
import java.util.*

@Composable
fun UserInfoScreen(
    modifier: Modifier = Modifier,
    setUserInfoState: (String, UserInfoTextFieldState) -> Unit,
    getProfileInfoName: String?,
    setProfileInfoName: (String) -> Unit,
    getUserInfoNameState: UserInfoTextFieldState,
    getProfileInfoGender: String?,
    setProfileInfoGender: (String) -> Unit,
    getProfileInfoBirth: Date?,
    setProfileInfoBirth: (Date) -> Unit,
    getProfileInfoAddress: String?,
    setProfileInfoAddress: (String) -> Unit,
    getUserInfoAddressState: UserInfoTextFieldState,
    getProfileInfoCareer: String?,
    setProfileInfoCareer: (String) -> Unit,
    getUserInfoCareerState: UserInfoTextFieldState
) {
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
                    setUserInfoState = setUserInfoState,
                    value = getProfileInfoName ?: "",
                    onValueChanged = { setProfileInfoName(it) },
                    onValueClear = { setProfileInfoName("") },
                    state = getUserInfoNameState,
                    label = "이름",
                    placeholder = "ex) 박우인"
                )
            }

//            item {
//                MarrytingDropdown(
//                    value = getProfileInfoGender ?: "",
//                    onValueChanged = { setProfileInfoGender(it) },
//                    state = genderState,
//                    label = "성별",
//                    placeholder = "성별을 선택해주세요"
//                )
//            }

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
                    setUserInfoState = setUserInfoState,
                    value = getProfileInfoAddress ?: "",
                    onValueChanged = { setProfileInfoAddress(it) },
                    onValueClear = { setProfileInfoAddress("") },
                    state = getUserInfoAddressState,
                    label = "사는 곳",
                    placeholder = "ex) 서울시 광진구"
                )
            }

            item {
                MarrytingTextField(
                    setUserInfoState = setUserInfoState,
                    value = getProfileInfoCareer ?: "",
                    onValueChanged = { setProfileInfoCareer(it) },
                    onValueClear = { setProfileInfoCareer("") },
                    state = getUserInfoCareerState,
                    label = "직업",
                    placeholder = "ex) IT 기획자"
                )
            }
        }
    }
}
