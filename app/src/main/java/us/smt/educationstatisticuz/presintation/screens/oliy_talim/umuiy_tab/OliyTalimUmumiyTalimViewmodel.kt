package us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab

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
import us.smt.educationstatisticuz.presintation.component.Region
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
            map = mapRegions
        )
    )
    val state: StateFlow<OliyTalimUmumiyState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.loadHomeStudentStatistic().collectLatest { result ->
                _state.update {
                    state.value.copy(
                        first = result
                    )
                }
            }
        }
    }
}