package com.marryting.app.presentation.picture

import android.graphics.Bitmap

interface PicturesScreenItemType {
    object AddPicture : PicturesScreenItemType
    data class ProfilePicture(val bitmap: Bitmap) : PicturesScreenItemType
}
