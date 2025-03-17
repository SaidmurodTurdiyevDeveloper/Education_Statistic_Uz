package us.smt.educationstatisticuz.presintation.screens.oliy_talim

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.otm_tab.OliyTalimOtmTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.OliyTalimStudentTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.table_tab.OliyTalimTableTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.teacher_tab.OliyTalimTeacherTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab.OliyTalimUmumiyTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab.OliyTalimUmumiyTalimViewmodel

const val oliyTalimRoute = "oliy_talim_screen"

@Composable
fun OliyTalimScreen(
    umumitViewModel:OliyTalimUmumiyTalimViewmodel
) {
    val selectedTab = remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ScrollableTabRow(
            selectedTabIndex = selectedTab.intValue
        ) {
            Tab(selected = selectedTab.intValue == 0, onClick = { selectedTab.intValue = 0 }) {
                Text(
                    "Umumiy",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.intValue == 1, onClick = { selectedTab.intValue = 1 }) {
                Text(
                    "Talabalar",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.intValue == 2, onClick = { selectedTab.intValue = 2 }) {
                Text(
                    "O'qituvchilar",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.intValue == 3, onClick = { selectedTab.intValue = 3 }) {
                Text(
                    "Otm ro`yxati",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.intValue == 4, onClick = { selectedTab.intValue = 4 }) {
                Text(
                    "Jadvallar",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        when (selectedTab.intValue) {
            0 -> OliyTalimUmumiyTab(viewmodel = umumitViewModel)
            1 -> OliyTalimStudentTab()
            2 -> OliyTalimTeacherTab()
            3 -> OliyTalimOtmTab()
            4 -> OliyTalimTableTab()
        }
    }
}