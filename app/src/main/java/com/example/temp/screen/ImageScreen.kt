package com.example.temp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.temp.model.ApiModelItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(vm: ImageScreenViewModel = ImageScreenViewModel()) {
    LaunchedEffect(key1 = Unit, block = {
        vm.getPhotos()
    })
    val photos by vm.photos.collectAsStateWithLifecycle()
    Scaffold(Modifier.fillMaxSize()) {
        PhotoListContent(paddingValues = it, photo = photos)
    }

}

@Composable
fun PhotoListContent(
    paddingValues: PaddingValues,
    photo: List<ApiModelItem>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = photo, key = {
            it.id
        }) {
          PhotoListItem(photo = it)
        }
    }
}

@Composable
fun PhotoListItem(photo: ApiModelItem) {

    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = photo.url)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                    }).build()
            ),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium),
            color = Color.Black
        ) {}
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Photo title ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(photo.title)
                    }

                },
                color = Color.White,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}

