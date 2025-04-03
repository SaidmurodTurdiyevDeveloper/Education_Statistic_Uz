package us.smt.educationstatisticuz.presintation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.get

enum class Region(val uzbekName: String) {
    ANDIJAN("Andijon viloyat"),
    FERGANA("Farg‘ona viloyat"),
    TASHKENT("Toshkent viloyat"),
    TASHKENT_CITY("Toshkent shahri"),
    NAMANGAN("Namangan viloyat"),
    SIRDARYA("Sirdaryo viloyat"),
    JIZZAKH("Jizzax viloyat"),
    NAVOI("Navoiy viloyat"),
    SAMARQAND("Samarqand viloyat"),
    ARAL("Orol Dengizi"),
    BUKHARA("Buxoro viloyat"),
    KASHKADARYA("Qashqadaryo viloyat"),
    SURKHANDARYA("Surxondaryo viloyat"),
    KHOREZM("Xorazm viloyat"),
    KARAKALPAKSTAN("Qoraqalpog‘iston Respublikasi");
}


@Composable
fun UzbekistanMap(map: Map<Region, Int>) {
    val selectedRegion = remember { mutableStateOf<Region?>(null) }
    val regionColors = remember {
        mutableListOf(
            Region.FERGANA,
            Region.ANDIJAN,
            Region.NAMANGAN,
            Region.TASHKENT_CITY,
            Region.SIRDARYA,
            Region.TASHKENT,
            Region.SAMARQAND,
            Region.ARAL,
            Region.KASHKADARYA,
            Region.SURKHANDARYA,
            Region.JIZZAKH,
            Region.KHOREZM,
            Region.BUKHARA,
            Region.NAVOI,
            Region.KARAKALPAKSTAN
        )
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Canvas(
                modifier = Modifier
                    .height(190.dp)
                    .width(290.dp)
                    .pointerInput(Unit) {
                        detectTapGestures { offset ->
                            val tappedRegion = regionColors.find { isPointInsideRegion(offset, it) }

                            tappedRegion?.let { region ->
                                selectedRegion.value = region
                            }
                        }
                    }
            ) {
                regionColors.forEach { region ->
                    drawRegion(
                        this,
                        getRegionPath(region),
                        if (region == selectedRegion.value) Color.Yellow.copy(0.3f) else Color.Green.copy(
                            0.3f
                        )
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
            AnimatedVisibility(
                visible = selectedRegion.value != null
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        ) {
                            if (selectedRegion.value != null)
                                append(selectedRegion.value?.uzbekName)
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp
                            )
                        ) {
                            if (selectedRegion.value != null && map[selectedRegion.value] != null)
                                append("\nJami: ${map[selectedRegion.value]}")
                        }
                    },
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private fun isPointInsideRegion(point: Offset, region: Region): Boolean {
    return getRegionPath(region).getBounds().contains(point)
}

private fun getRegionPath(region: Region): Path {
    return when (region) {
        Region.ANDIJAN -> andijanPath()
        Region.FERGANA -> fargonaPath()
        Region.NAMANGAN -> namanganPath()
        Region.TASHKENT -> tashkentPath()
        Region.ARAL -> aralPath()
        Region.TASHKENT_CITY -> tashkentCityPath()
        Region.SIRDARYA -> sirdaryaPath()
        Region.JIZZAKH -> jizzakhPath()
        Region.SAMARQAND -> samarqandPath()
        Region.NAVOI -> navoiPath()
        Region.BUKHARA -> bukharaPath()
        Region.KASHKADARYA -> kashkadaryaPath()
        Region.SURKHANDARYA -> surkhandaryaPath()
        Region.KHOREZM -> khorezmPath()
        Region.KARAKALPAKSTAN -> karakalpakstanPath()
    }
}

private fun drawRegion(drawScope: DrawScope, path: Path, color: Color) {
    drawScope.drawPath(path = path, color = color, style = Fill)
    drawScope.drawPath(path = path, color = Color.DarkGray, style = Stroke())
}

@Preview
@Composable
private fun UzbekistanMapPrev() {
    UzbekistanMap(map = mapOf())
}
