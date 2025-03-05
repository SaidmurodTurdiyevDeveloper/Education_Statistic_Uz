package us.smt.educationstatisticuz.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramDataWithColor
import kotlin.math.atan2
import kotlin.math.pow
import kotlin.math.sqrt


@SuppressLint("DefaultLocale")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CircularDiagram(
    data: CommonDiagramData<DiagramDataWithColor>
) {
    val selected = remember {
        mutableStateOf(data.types.keys.first())
    }
    var selectedSlice by remember { mutableStateOf<DiagramDataWithColor?>(null) }
    var tapOffset by remember { mutableStateOf(Offset.Zero) }
    val isOpen = remember {
        mutableStateOf(false)
    }
    val all = data.types[selected.value]?.sumOf { it.value } ?: 0
    Card(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 8.dp, top = 8.dp),
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
            Spacer(modifier = Modifier.height(32.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
            ) {
                Canvas(modifier =Modifier
                    .size(200.dp)
                    .pointerInput(Unit) {
                        detectTapGestures { offset ->
                            var startAngle = -90f
                            val canvasSize = 200f
                            val radius = canvasSize / 2
                            val center = Offset(radius, radius) // Dinamik markaz

                            // Bosilgan joyning markazdan uzoqligini tekshiramiz
                            val distance = sqrt(
                                (offset.x - center.x).pow(2) + (offset.y - center.y).pow(2)
                            )

                            if (distance in (radius - 75f)..radius) { // Radius ichida bo'lsa
                                var tappedAngle = Math.toDegrees(
                                    atan2(
                                        (offset.y - center.y).toDouble(),
                                        (offset.x - center.x).toDouble()
                                    )
                                ).toFloat() + 90f

                                if (tappedAngle < 0) tappedAngle += 360f // Manfiy burchaklarni tuzatish

                                data.types[selected.value]?.forEach { value ->
                                    val angle = value.value / all * 360f

                                    if (tappedAngle in startAngle..(startAngle + angle)) {
                                        selectedSlice = value
                                        tapOffset = offset
                                    }

                                    startAngle += angle
                                }
                            }
                        }
                    }

                ) {
                    var startAngle = -90f
                    data.types[selected.value]?.forEach { diagramData ->
                        val angle = diagramData.value.toFloat() / all * 360f
                        drawArc(
                            color = diagramData.color,
                            startAngle = startAngle + 1f,
                            sweepAngle = angle - 1f,
                            useCenter = false,
                            style = Stroke(width = 150f, cap = StrokeCap.Butt),
                            size = Size(size.width, size.height)
                        )
                        startAngle += angle
                    }
                }

                Text(
                    text = all.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(56.dp))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                data.types[selected.value]?.forEach { diagramData ->
                    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .width(28.dp)
                                .height(16.dp)
                                .background(diagramData.color, shape = RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = diagramData.name,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.W400,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        val formatted = String.format("%.2f", (diagramData.value.toDouble() / all.toDouble() * 100.0))
                        Text(
                            text = "$formatted%",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.W600,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
    selectedSlice?.let { label ->
        Box(
            modifier = Modifier
                .offset { IntOffset(tapOffset.x.toInt(), tapOffset.y.toInt()) }
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    append(label.name)
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = label.color,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(label.value.toString())
                    }
                },
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}


@Preview
@Composable
private fun CircularDiagramPrev() {
    CircularDiagram(
        data = CommonDiagramData(
            title = "Talabalar soni jins kesimida\n", types = mapOf(
                "Jami" to listOf(
                    DiagramDataWithColor(
                        name = "Erkaklar", value = 154, color = Color.Blue
                    ), DiagramDataWithColor(
                        name = "Ayollar", value = 56, color = Color.Red
                    )
                ), "Davlat" to listOf(
                    DiagramDataWithColor(
                        name = "Erkaklar", value = 16, color = Color.Blue
                    ), DiagramDataWithColor(
                        name = "Ayollar", value = 50, color = Color.Red
                    )
                )
            )
        )
    )
}