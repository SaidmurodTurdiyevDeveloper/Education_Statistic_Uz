package us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.talim_turi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TalimTuri() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
            .padding(16.dp)
    ) {
        item {
            EducationCard(
                "Bakalavr",
                1486019,
                704931,
                47.44f,
                781088,
                52.56f,
                Icons.Default.Person
            )
        }
        item {
            EducationCard(
                "Magistratura",
                37395,
                14094,
                37.69f,
                23301,
                62.31f,
                Icons.Default.Person
            )
        }
        item { EducationCard("Ordinatura", 5166, 3098, 59.97f, 2068, 40.03f, Icons.Default.Person) }
    }
}

@Composable
fun EducationCard(
    title: String,
    total: Int,
    males: Int,
    malePercent: Float,
    females: Int,
    femalePercent: Float,
    iconVector: ImageVector
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = iconVector,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Umumiy: $total", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text("Erkaklar: $males (${malePercent}%)", color = Color(0xFF27AE60))
                Spacer(modifier = Modifier.width(16.dp))
                Text("Ayollar: $females (${femalePercent}%)", color = Color(0xFFC0392B))
            }
        }
    }
}