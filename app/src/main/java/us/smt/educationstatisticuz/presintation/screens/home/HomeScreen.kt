package us.smt.educationstatisticuz.presintation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val homeRoute = "home_screen"

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(Color(0xFFEFF4F8))
    ) {

        // Search bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Oliy va o‘rta maxsus ta’lim...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Yangiliklar karuseli (horizontal scroll)
        LazyRow(
            modifier = Modifier.Companion.padding(vertical = 8.dp, horizontal = 16.dp)
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

        // Oliy ta'lim va Kasb ta'lim statistikasi
        Column(Modifier.Companion.padding(horizontal = 16.dp)) {
            Text("Oliy ta’lim", fontWeight = FontWeight.Companion.Bold, fontSize = 18.sp)

            Row(Modifier.Companion.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InfoCard(title = "Universitetlar", value = "208")
                InfoCard(title = "Talabalar", value = "45020")
            }

            Spacer(modifier = Modifier.Companion.height(12.dp))

            Text("Kasb ta’lim", fontWeight = FontWeight.Companion.Bold, fontSize = 18.sp)

            Row(Modifier.Companion.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InfoCard(title = "O‘quvchilar", value = "160 250")
                InfoCard(title = "Kasb-hunar", value = "22 450")
            }
        }

        Spacer(modifier = Modifier.Companion.height(16.dp))

        // Qabul statistikasi progress bar
        Text("Qabul statistikasi", fontSize = 18.sp, fontWeight = FontWeight.Companion.Bold, modifier = Modifier.Companion.padding(horizontal = 16.dp))
        Column(Modifier.Companion.padding(horizontal = 16.dp)) {
            StatBar(title = "Bakalavr", value = 694279f, max = 800000f, color = Color(0xFF4CAF50))
            StatBar(title = "Magistratura", value = 33172f, max = 800000f, color = Color(0xFFFF9800))
            StatBar(title = "Akademik litsey", value = 44356f, max = 800000f, color = Color(0xFF2196F3))
            StatBar(title = "Kasb-hunar maktabi", value = 37587f, max = 800000f, color = Color(0xFF9C27B0))
            StatBar(title = "O‘rta maxsus", value = 61588f, max = 800000f, color = Color(0xFF795548))
        }

        Spacer(modifier = Modifier.Companion.height(32.dp))
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
                .height(8.dp)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp)),
            color = color
        )
    }
}