package us.smt.educationstatisticuz.presintation.component

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramDataWithColor
import us.smt.educationstatisticuz.model.DiagramType


@Composable
fun HorizontalScreen(
    color: Color,
    count: Int,
    paddingStart: Dp = 32.dp,
    data: CommonDiagramData
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

        Column(modifier = Modifier.fillMaxWidth()) {
            data.types[selected.value]?.forEach { item ->
                BarChartItem(
                    label = item.name,
                    color = color,
                    value = item.value,
                    maxValue = (maxValue?.value) ?: 0
                )
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
private fun HorizontalScreenPrev() {
    MaterialTheme {
        Surface {
            HorizontalScreen(
                color = Color.Cyan,
                count = 4,
                data = CommonDiagramData(
                    type = DiagramType.VERTICAL,
                    count = 5,
                    color = Color.Green,
                    paddingStart = 30,
                    title = "Talabalar soni jins kesimida\n",
                    types = mapOf(
                        "Jami" to listOf(
                            DiagramDataWithColor(
                                name = "Erkaklar",
                                value = 716267,
                                color = Color.Red
                            ), DiagramDataWithColor(
                                name = "Ayollar", value = 56,
                                color = Color.Red
                            )
                        ), "Davlat" to listOf(
                            DiagramDataWithColor(
                                name = "Erkaklar", value = 16,
                                color = Color.Red
                            ), DiagramDataWithColor(
                                name = "Ayollar", value = 50,
                                color = Color.Red
                            )
                        )
                    )
                )
            )
        }
    }
}
