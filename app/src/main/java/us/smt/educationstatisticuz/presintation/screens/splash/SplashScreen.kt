package us.smt.educationstatisticuz.presintation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import us.smt.educationstatisticuz.R
import us.smt.educationstatisticuz.ui.SF_PRo_DISPLAY

const val splash = "Splash"

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E4A39))
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_splash),
                contentDescription = "icSplash"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "stat.edu.uz",
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    lineHeight = 26.sp,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = SF_PRo_DISPLAY,
                    color = Color.White
                )
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(R.drawable.ic_intro),
                contentDescription = "icIntro"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Raqamli ta’lim texnologiyalarni \nrivojlantirish markazi",
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    lineHeight = 16.sp,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    fontFamily = SF_PRo_DISPLAY,
                    color = Color.White
                )
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPrev() {
    SplashScreen()
}