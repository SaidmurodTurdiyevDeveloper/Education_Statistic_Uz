package us.smt.educationstatisticuz.model

import androidx.compose.ui.graphics.Color

data class CommonDiagramData(
    val type: DiagramType,
    val color: Color,
    val paddingStart: Int,
    val count: Int,
    val title: String,
    val types: Map<String, List<DiagramDataWithColor>>
)
