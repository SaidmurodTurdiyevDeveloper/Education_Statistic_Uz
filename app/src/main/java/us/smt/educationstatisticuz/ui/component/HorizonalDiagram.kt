package us.smt.educationstatisticuz.ui.component

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramData


@Composable
fun StudentChartScreen(
    color: Color,
    count: Int,
    paddingStart: Dp = 32.dp,
    data: CommonDiagramData<DiagramData>
) {

    val isOpen = remember {
        mutableStateOf(false)
    }
    val selected = remember {
        mutableStateOf(data.types.keys.first())
    }
    val maxValue = data.types[selected.value]?.maxBy { it.value }
    val minimum = getMinimum(maxValue?.value ?: 0, count)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header with Dropdown
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = data.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp
            )
            if (data.types.size > 1) {
                DropDown(
                    modifier = Modifier,
                    list = data.types.keys.toList(),
                    isOpen = isOpen.value,
                    onOpen = {
                        isOpen.value = true
                    },
                    onDismiss = {
                        isOpen.value = false
                    },
                    select = {
                        selected.value = it
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Bar Chart
        Column(modifier = Modifier.fillMaxWidth()) {
            data.types[selected.value]?.forEach { item ->
                BarChartItem(
                    label = item.name,
                    color = color,
                    value = item.value,
                    maxValue = (maxValue?.value) ?: 0
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

            }
        }
    }
}

@Composable
fun BarChartItem(label: String, value: Int, color: Color, maxValue: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        ) {
            VerticalDivider(color = color, thickness = 0.5.dp)
            Box(
                modifier = Modifier
                    .fillMaxWidth(value.toFloat() / maxValue.toFloat())
                    .height(24.dp)
                    .background(color, RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)),
                contentAlignment = Alignment.CenterEnd
            ) {
                if (value / maxValue > 0.5) {
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = value.toString(),
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            if (value / maxValue <= 0.5) {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = value.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview
@Composable
private fun StudentChartScreenPrev() {
    MaterialTheme {
        Surface {
            StudentChartScreen(
                color = Color.Cyan,
                count = 4,
                data = CommonDiagramData(
                    title = "Talabalar soni jins kesimida\n", types = mapOf(
                        "Jami" to listOf(
                            DiagramData(
                                name = "Erkaklar", value = 716267
                            ), DiagramData(
                                name = "Ayollar", value = 56
                            )
                        ), "Davlat" to listOf(
                            DiagramData(
                                name = "Erkaklar", value = 16
                            ), DiagramData(
                                name = "Ayollar", value = 50
                            )
                        )
                    )
                )
            )
        }
    }
}
