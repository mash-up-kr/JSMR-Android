package com.marryting.app.presentation.picture

import android.graphics.Bitmap

interface PictureScreenItemType {
    object AddPicture : PictureScreenItemType
    data class ProfilePicture(val bitmap: Bitmap) : PictureScreenItemType
}
