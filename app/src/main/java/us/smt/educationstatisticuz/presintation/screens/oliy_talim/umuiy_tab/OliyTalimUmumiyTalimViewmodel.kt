package us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import us.smt.educationstatisticuz.domen.repository.OliyTalimRepository
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramDataWithColor
import us.smt.educationstatisticuz.model.DiagramType
import us.smt.educationstatisticuz.presintation.component.Region
import us.smt.educationstatisticuz.ui.getRandomComposeColor
import javax.inject.Inject

@HiltViewModel
class OliyTalimUmumiyTalimViewmodel @Inject constructor(
    private val repository: OliyTalimRepository
) : ViewModel() {
    private val mapRegions = mapOf(
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
    private val _state = MutableStateFlow(
        OliyTalimUmumiyState(
            map = mapRegions,
            common = listOf(
                CommonDiagramData(
                    type = DiagramType.CIRCULAR,
                    color = getRandomComposeColor(),
                    count = 0,
                    paddingStart = 30,
                    title = "OTMlar soni mulkchilik shakli bo`yicha",
                    types = mapOf(
                        "All" to listOf(
                            DiagramDataWithColor(
                                name = "Davlatlar",
                                value = 108,
                                color = Color(0xFF43B1A0)
                            ),
                            DiagramDataWithColor(
                                name = "Nodavlatlar",
                                value = 70,
                                color = Color(0xFF4DA2F1)
                            ),
                            DiagramDataWithColor(
                                name = "Xorijiy",
                                value = 30,
                                color = Color(0xFFFFD426)
                            )
                        )
                    )
                ),
                CommonDiagramData(
                    type = DiagramType.VERTICAL,
                    color = Color(0xFFA1DD75),
                    count = 5,
                    paddingStart = 50,
                    title = "OTMlar soni tashkiliy turi bo`yicha",
                    types = mapOf(
                        "All" to listOf(
                            DiagramDataWithColor(
                                name = "Konservatoriya",
                                value = 1,
                                color = Color(0xFF43B1A0)

                            ),
                            DiagramDataWithColor(
                                name = "Akademiya",
                                value = 5,
                                color = Color(0xFF43B1A0)
                            ),
                            DiagramDataWithColor(
                                name = "Filial",
                                value = 40,
                                color = Color(0xFF43B1A0)

                            ),
                            DiagramDataWithColor(
                                name = "Institut",
                                value = 53,
                                color = Color(0xFF43B1A0)
                            ),
                            DiagramDataWithColor(
                                name = "Universitet",
                                value = 109,
                                color = Color(0xFF43B1A0)
                            )
                        )
                    )
                )
            )
        )
    )
    val state: StateFlow<OliyTalimUmumiyState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.loadHomeStudentStatistic().collectLatest { result ->
                _state.update {
                    state.value.copy(
                        students = result
                    )
                }
            }
        }
    }
}