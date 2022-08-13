package com.marryting.app.presentation.picture

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.core.content.ContextCompat
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.marryting.app.R
import com.marryting.app.component.MarrytingButtonColorSet
import com.marryting.app.component.MarrytingButtonType
import com.marryting.app.component.MarrytingIconButton
import com.ui.theme.Color
import com.ui.theme.DarkColor
import com.ui.theme.KoreaTypography
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = Color.DarkBackground
    ) {
        val pictureList = remember { mutableStateListOf<PicturesScreenItemType>() }
        val pagerState = rememberPagerState()

        HorizontalPager(
            state = pagerState,
            count = pictureList.size + 1,
            verticalAlignment = Alignment.Top,
            contentPadding = PaddingValues(horizontal = 56.dp, vertical = 40.dp)
        ) { page ->
            when (page) {
                pictureList.size -> {
                    PictureAddScreen { bitmapList ->
                        bitmapList.forEach {
                            pictureList.add(PicturesScreenItemType.ProfilePicture(it))
                        }
                    }
                }
                else -> {
                    Column {
                        Card(
                            modifier = Modifier
                                .graphicsLayer {
                                    val pageOffset =
                                        calculateCurrentOffsetForPage(page).absoluteValue

                                    lerp(
                                        start = 1f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    ).also { scale ->
                                        scaleX = scale
                                        scaleY = scale
                                    }

                                    alpha = lerp(
                                        start = 0.6f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                }
                        ) {
                            val bitmapImage =
                                (pictureList[page] as PicturesScreenItemType.ProfilePicture).bitmap.asImageBitmap()
                            Image(
                                bitmap = bitmapImage,
                                contentDescription = null,
                                contentScale = ContentScale.Inside,
                                modifier = Modifier
                                    .width(280.dp)
                                    .height(374.dp)
                            )
                        }

                        if (pictureList.size >= 2) {
                            Spacer(modifier = Modifier.height(8.dp))
                            MarrytingIconButton(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                buttonType = MarrytingButtonType.Icon(
                                    activeColorSet = MarrytingButtonColorSet(
                                        contentColor = DarkColor.Grey200,
                                        backgroundColor = DarkColor.Grey700
                                    ),
                                    pressedColorSet = MarrytingButtonColorSet(
                                        contentColor = DarkColor.Grey100,
                                        backgroundColor = DarkColor.Grey600
                                    ),
                                    contentPaddingValues = PaddingValues(12.dp)
                                ),
                                onClick = { },
                                drawableRes = R.drawable.ic_trash
                            )
                        }
                    }
                }
            }
        }

        if (pictureList.isNotEmpty()) {
            LaunchedEffect(key1 = pictureList.size) {
                delay(500)  // 임시
                pagerState.animateScrollToPage(pictureList.size - 1)
            }
        }
    }
}

@Composable
fun PictureAddScreen(bitmapList: (List<Bitmap>) -> Unit) {
    val context = LocalContext.current
    var selectedImagesUri by remember { mutableStateOf(listOf<Uri>()) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents(),
        onResult = {
            selectedImagesUri = it
            val newBitmapList = mutableListOf<Bitmap>()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                selectedImagesUri.forEach { uri ->
                    val source = ImageDecoder.createSource(context.contentResolver, uri)
                    newBitmapList.add(ImageDecoder.decodeBitmap(source))
                }
            } else {
                selectedImagesUri.forEach { uri ->
                    newBitmapList.add(MediaStore.Images.Media.getBitmap(context.contentResolver, uri))
                }
            }
            bitmapList(newBitmapList)
        }
    )

    val requestPermission = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) -> {
                    launcher.launch("image/*")
                }
            }
        }
    )

    Box(
        modifier = Modifier
            .width(280.dp)
            .height(374.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(DarkColor.Grey700)
            .border(2.dp, DarkColor.Grey200, RoundedCornerShape(16.dp))
            .clickable(
                onClick = {
                    requestPermission.launch(
                        arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    )
                }
            )
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_photo_add),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                color = DarkColor.Grey300,
                text = "사진 추가",
                style = KoreaTypography.body1
            )
        }
    }
}
