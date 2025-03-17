package us.smt.educationstatisticuz.ui.component

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramData


@Composable
fun VerticalDiagram(
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
    Card(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
            Spacer(modifier = Modifier.height(18.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(324.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .offset(y = (-12).dp)
                            .padding(vertical = 6.dp),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        for (i in count downTo 0) {
                            Text(
                                text = "${i * minimum}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.W600,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .height(300.dp)
                            .weight(1f),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        for (i in 0..count) {
                            HorizontalDivider()
                        }
                    }
                }
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(324.dp)
                        .padding(start = paddingStart),
                    verticalAlignment = Alignment.Bottom
                ) {
                    data.types[selected.value]?.forEach { item ->
                        item {
                            val height = 300 * item.value.toDouble() / (minimum * count)
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Box(
                                    modifier = Modifier
                                        .height(height.dp)
                                        .padding(horizontal = 20.dp)
                                        .width(56.dp)
                                        .background(
                                            color = color, shape = RoundedCornerShape(4.dp)
                                        )
                                )
                                Text(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .padding(top = 4.dp),
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


fun getMinimum(value: Int, count: Int): Int {
    val t = value.toDouble() / count.toDouble()
    return when (t.toInt()) {
        in 1..9 -> {
            kotlin.math.ceil(t).toInt()
        }

        in 10..99 -> {
            kotlin.math.ceil(t / 10).toInt() * 10
        }

        in 100..999 -> {
            kotlin.math.ceil(t / 100).toInt() * 100
        }

        in 1000..9999 -> {
            kotlin.math.ceil(t / 1000).toInt() * 1000
        }

        in 10000..99999 -> {
            kotlin.math.ceil(t / 10000).toInt() * 10000
        }

        in 100000..999999 -> {
            kotlin.math.ceil(t / 100000).toInt() * 100000
        }

        in 1000000..9999999 -> {
            kotlin.math.ceil(t / 1000000).toInt() * 1000000
        }

        in 10000000..99999999 -> {
            kotlin.math.ceil(t / 10000000).toInt() * 10000000
        }

        in 100000000..999999999 -> {
            kotlin.math.ceil(t / 100000000).toInt() * 100000000
        }

        in 1000000000..Int.MAX_VALUE -> {
            kotlin.math.ceil(t / 1000000000).toInt() * 1000000000
        }

        else -> {
            kotlin.math.ceil(t).toInt()
        }
    }
}

@Preview
@Composable
private fun CircularDiagramPrev() {
    VerticalDiagram(
        color = Color.Green,
        count = 4,
        data = CommonDiagramData(
            title = "Talabalar soni jins kesimida\n", types = mapOf(
                "Jami" to listOf(
                    DiagramData(
                        name = "Erkaklar", value = 154
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