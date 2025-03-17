package us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab

import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.presintation.component.Region

data class OliyTalimUmumiyState(
    val allOTMCount:Int=0,
    val allProfessorCount:Int=0,
    val allStudentCount:Int=0,
    val first: List<CommonDiagramData> = emptyList(),
    val map: Map<Region, Int> = mapOf(),
    val second: List<CommonDiagramData> = emptyList()
)
