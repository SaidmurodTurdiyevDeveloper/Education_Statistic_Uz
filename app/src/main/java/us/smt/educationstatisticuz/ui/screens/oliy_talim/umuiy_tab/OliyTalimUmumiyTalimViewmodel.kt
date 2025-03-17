package us.smt.educationstatisticuz.ui.screens.oliy_talim.umuiy_tab

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import us.smt.educationstatisticuz.ui.component.Region

class OliyTalimUmumiyTalimViewmodel : ViewModel() {
    val mapRegions = mutableStateMapOf(
        Region.KARAKALPAKSTAN to 12,
        Region.KHOREZM to 8,
        Region.NAVOI to 3,
        Region.JIZZAKH to 5,
        Region.SAMARQAND to 14,
        Region.KASHKADARYA to 9,
        Region.SURKHANDARYA to 6,
        Region.BUKHARA to 11,
        Region.SIRDARYA to 33,
        Region.TASHKENT to 14,
        Region.TASHKENT_CITY to 92,
        Region.NAMANGAN to 9,
        Region.FERGANA to 13,
        Region.ANDIJAN to 9,
    )
}