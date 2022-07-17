package com.marryting.app

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarrytingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val keyHash = Utility.getKeyHash(this)

        KakaoSdk.init(this, keyHash)
    }
}
