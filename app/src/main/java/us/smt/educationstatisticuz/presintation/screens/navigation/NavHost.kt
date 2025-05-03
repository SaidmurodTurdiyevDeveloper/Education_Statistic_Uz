package us.smt.educationstatisticuz.presintation.screens.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import us.smt.educationstatisticuz.presintation.screens.doctarantura.DoctranturaScreen
import us.smt.educationstatisticuz.presintation.screens.doctarantura.doktantura
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.OliyTalimScreen
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.oliyTalimRoute
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.otm_tab.OliyTalimOtmViewModel
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab.OliyTalimUmumiyTalimViewmodel
import us.smt.educationstatisticuz.presintation.screens.professional_talim.ProfessionalTalimScreen
import us.smt.educationstatisticuz.presintation.screens.professional_talim.professionalTalim
import us.smt.educationstatisticuz.presintation.screens.qabul_screen.QabulScreen
import us.smt.educationstatisticuz.presintation.screens.qabul_screen.qabul
import us.smt.educationstatisticuz.presintation.screens.splash.SplashScreen
import us.smt.educationstatisticuz.presintation.screens.splash.splash
import us.smt.educationstatisticuz.presintation.screens.tab.TabNavHost
import us.smt.educationstatisticuz.presintation.screens.tab.tabNavHostRoute
import us.smt.educationstatisticuz.ui.EducationStatisticUzTheme

const val OLIY_TALIM = "Oliy ta'lim"
const val PROFESSIONAL_TALIM = "Professional ta'lim"
const val QABUL = "Qabul"
const val DOCTARANTURA = "Doktorantura"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost() {
    val isDarkMode = remember { mutableStateOf(false) }
    val navController = rememberNavController()
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(tabNavHostRoute)
    }
    EducationStatisticUzTheme(
        darkTheme = isDarkMode.value
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = splash
        ) {
            composable(splash) {
                SplashScreen()
            }
            composable(tabNavHostRoute) {
                TabNavHost()
            }
            composable(oliyTalimRoute) {
                val viewmodel = hiltViewModel<OliyTalimUmumiyTalimViewmodel>()
                val oliyTalim = hiltViewModel<OliyTalimOtmViewModel>()
                OliyTalimScreen(viewmodel, oliyTalim)
            }
            composable(professionalTalim) {
                ProfessionalTalimScreen()
            }
            composable(qabul) {
                QabulScreen()
            }
            composable(doktantura) {
                DoctranturaScreen()
            }
        }
    }
}

private fun getTitle(index: Int): String {
    return when (index) {
        0 -> OLIY_TALIM
        1 -> PROFESSIONAL_TALIM
        2 -> QABUL
        3 -> DOCTARANTURA
        else -> "Meining Ilovam"
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    AppNavHost()
}