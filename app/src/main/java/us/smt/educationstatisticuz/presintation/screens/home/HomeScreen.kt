package us.smt.educationstatisticuz.presintation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import us.smt.educationstatisticuz.R
import us.smt.educationstatisticuz.ui.SF_PRo_DISPLAY

const val homeRoute = "home_screen"

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(Color(0xFF03331F))
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(30.dp)
                    .height(40.dp),
                painter = painterResource(R.drawable.ic_splash),
                contentDescription = "icLogo"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "stat.edu.uz",
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    lineHeight = 21.sp,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = SF_PRo_DISPLAY,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "icEdit", tint = Color.White)
            }
        }
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Oliy va o‘rta maxsus ta’lim...") },
            trailingIcon = { Icon(Icons.Default.Search, contentDescription = "icSearch") },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 14.sp
            ),
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(top = 60.dp)
                .zIndex(10f)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, Color(0xFF03331F), RoundedCornerShape(10.dp))
                .background(Color.White)

        )
        LazyColumn(
            modifier = Modifier
                .padding(top = 90.dp)
                .fillMaxSize()
                .background(Color.LightGray, shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
            contentPadding = PaddingValues(top = 32.dp, start = 16.dp, end = 16.dp)
        ) {
            item {
                Text(
                    "Yangiliklar",
                    fontWeight = FontWeight.Companion.W700,
                    fontSize = 24.sp,
                    lineHeight = 21.sp,
                    fontFamily = SF_PRo_DISPLAY,
                    color = Color(0xFF03331F)
                )

                LazyRow(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    items(4) { index ->
                        Card(
                            modifier = Modifier.Companion
                                .width(160.dp)
                                .height(100.dp)
                                .padding(end = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Box(contentAlignment = Alignment.Companion.Center) {
                                Text("Yangilik ${index + 1}")
                            }
                        }
                    }
                }
            }
            item {
                Column(Modifier) {
                    Text(
                        "Oliy ta’lim",
                        fontWeight = FontWeight.Companion.W700,
                        fontSize = 24.sp,
                        lineHeight = 21.sp,
                        fontFamily = SF_PRo_DISPLAY,
                        color = Color(0xFF03331F)
                    )

                    Row(Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        InfoCard(title = "Universitetlar", value = "208")
                        InfoCard(title = "Talabalar", value = "45020")
                    }

                    Spacer(modifier = Modifier.Companion.height(12.dp))

                    Text(
                        "Kasb ta’lim",
                        fontWeight = FontWeight.Companion.W700,
                        fontSize = 24.sp,
                        lineHeight = 21.sp,
                        fontFamily = SF_PRo_DISPLAY,
                        color = Color(0xFF03331F)
                    )

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        InfoCard(title = "O‘quvchilar", value = "160 250")
                        InfoCard(title = "Kasb-hunar", value = "22 450")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Qabul statistikasi progress bar
                Text(
                    "Qabul statistikasi",
                    fontWeight = FontWeight.Companion.W700,
                    fontSize = 24.sp,
                    lineHeight = 21.sp,
                    fontFamily = SF_PRo_DISPLAY,
                    color = Color(0xFF03331F)
                )
                Column(Modifier.padding(vertical = 8.dp)) {
                    StatBar(title = "Bakalavr", value = 694279f, max = 800000f, color = Color(0xFF4CAF50))
                    StatBar(title = "Magistratura", value = 33172f, max = 800000f, color = Color(0xFFFF9800))
                    StatBar(title = "Akademik litsey", value = 44356f, max = 800000f, color = Color(0xFF2196F3))
                    StatBar(title = "Kasb-hunar maktabi", value = 37587f, max = 800000f, color = Color(0xFF9C27B0))
                    StatBar(title = "O‘rta maxsus", value = 61588f, max = 800000f, color = Color(0xFF795548))
                }

                Spacer(modifier = Modifier.Companion.height(32.dp))
            }
        }


    }

}

@Composable
private fun InfoCard(title: String, value: String) {
    Card(
        modifier = Modifier.Companion
            .fillMaxWidth(1f)
            .height(80.dp)
            .padding(end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Companion.White),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            Modifier.Companion
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, fontSize = 14.sp)
            Text(value, fontWeight = FontWeight.Companion.Bold, fontSize = 18.sp)
        }
    }
}

@Composable
private fun StatBar(title: String, value: Float, max: Float, color: Color) {
    Column(Modifier.Companion.padding(vertical = 4.dp)) {
        Text("$title: ${value.toInt()}", fontSize = 14.sp)
        LinearProgressIndicator(
            progress = { value / max },
            modifier = Modifier.Companion
                .fillMaxWidth()
                .height(40.dp)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp)),
            color = color
        )
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}