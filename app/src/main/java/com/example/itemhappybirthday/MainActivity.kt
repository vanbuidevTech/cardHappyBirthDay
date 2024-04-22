package com.example.itemhappybirthday

import android.os.Bundle
import androidx.activity.BackEventCompat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.itemhappybirthday.ui.theme.ItemHappyBirthDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemHappyBirthDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Common()
                }
            }
        }
    }
}

@Composable
fun Common(modifier: Modifier = Modifier) {
    GreetingImage(
        h1 = stringResource(id = R.string.jenifer_doe),
        h2 = stringResource(id = R.string.android_developer_extraordinaire),
        painterImage = painterResource(id = R.drawable.android_logo),
        phone = stringResource(id = R.string.phone_user),
        share = stringResource(id = R.string.share_to),
        email = stringResource(id = R.string.email_to),
        xmlPhone = painterResource(id = R.drawable.baseline_call_24),
        xmlShare = painterResource(id = R.drawable.baseline_share_24),
        xmlEmail = painterResource(id = R.drawable.baseline_email_24),
    )
}

@Composable
fun GreetingImage(
    h1: String,
    h2: String,
    painterImage: Painter,
    phone: String,
    share: String,
    email: String,
    xmlPhone: Painter,
    xmlEmail: Painter,
    xmlShare: Painter,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // `Column` chứa `Image` và `GreetingText` ở giữa màn hình
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Hiển thị `Image`
            Image(
                painter = painterImage,
                contentDescription = "Android Logo",
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .background(Color.Gray)
            )

            // Hiển thị `GreetingText`
            GreetingText(h1, h2)
        }

        // `Column` chứa `Info` ở phía dưới cùng màn hình
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Gọi hàm `Info` để hiển thị thông tin liên hệ
            InfoSection(xmlPhone, phone)
            InfoSection(xmlEmail, email)
            InfoSection(xmlShare, share)
        }
    }
}

@Composable
fun InfoSection(iconPainter: Painter, text: String) {
    // Tạo một `Row` để chứa `Icon` và `Text`
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = text)
    }
}

@Composable
fun GreetingText(
    h1: String,
    h2: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = h1,
        fontSize = 40.sp,
        modifier = modifier.padding(bottom = 8.dp)
    )
    Text(
        text = h2,
        color = Color.Green
    )
}

@Composable
fun Info(phone: String, share: String, email: String, modifier: Modifier = Modifier) {
    Text(
        text = phone,
        modifier = modifier.padding(bottom = 8.dp)
    )
    Text(
        text = share,
        modifier = modifier.padding(bottom = 8.dp)
    )
    Text(
        text = email
    )
}


@Preview
@Composable
fun Show() {
    Common()
}