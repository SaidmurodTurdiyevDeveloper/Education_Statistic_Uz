package us.smt.educationstatisticuz.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class Region {
    ANDIJAN,
    FERGANA,
    TASHKENT_CITY,
    NAMANGAN,
    TASHKENT,
    SIRDARYA,
    JIZZAKH,
    SAMARQAND,
    NAVOI,
    ARAL,
    BUKHARA,
    KASHKADARYA,
    SURKHANDARYA,
    KHOREZM,
    KARAKALPAKSTAN;
}

@Composable
fun UzbekistanMap() {
    val selectedRegion = remember { mutableStateOf<Region?>(null) }
    val regionColors = remember {
        mutableStateMapOf<Region, Color>().apply {
            Region.entries.forEach { this[it] = Color.Green.copy(alpha = 0.3f) }
        }
    }

    Canvas(
        modifier = Modifier
            .height(200.dp)
            .width(300.dp)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    regionColors.keys.forEach { region ->
                        if (isPointInsideRegion(offset, region)) {
                            if (selectedRegion.value != null) {
                                regionColors[selectedRegion.value!!] = Color.Green.copy(alpha = 0.3f)
                            }
                            selectedRegion.value = region
                            regionColors[region] = Color.Yellow.copy(alpha = 0.3f)
                        }
                    }
                }
            }
    ) {
        regionColors.forEach { (region, color) ->
            drawRegion(this, getRegionPath(region), color)
        }
    }
}

fun isPointInsideRegion(point: Offset, region: Region): Boolean {
    return getRegionPath(region).getBounds().contains(point)
}

fun getRegionPath(region: Region): Path {
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

fun drawRegion(drawScope: DrawScope, path: Path, color: Color) {
    drawScope.drawPath(path = path, color = color, style = Fill)
    drawScope.drawPath(path = path, color = Color.DarkGray, style = Stroke())
}

@Preview
@Composable
private fun UzbekistanMapPrev() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                UzbekistanMap()
            }
        }
    }
}
