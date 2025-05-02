package us.smt.educationstatisticuz.presintation.screens.oliy_talim

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.otm_tab.OliyTalimOtmTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.otm_tab.OliyTalimOtmViewModel
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.OliyTalimStudentTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.table_tab.OliyTalimTableTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.teacher_tab.OliyTalimTeacherTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab.OliyTalimUmumiyTab
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab.OliyTalimUmumiyTalimViewmodel

const val oliyTalimRoute = "oliy_talim_screen"

@Composable
fun OliyTalimScreen(
    umumitViewModel: OliyTalimUmumiyTalimViewmodel,
    oliyTalimOtmViewModel: OliyTalimOtmViewModel
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
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTab.intValue,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTab.intValue])
                        .clip(
                            RoundedCornerShape(16.dp)
                        ),
                    height = 50.dp,
                    color = Color.Blue
                )
            }
        ) {
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 0,
                onClick = { selectedTab.intValue = 0 }) {
                Text(
                    "Umumiy",
                    modifier = Modifier.padding(12.dp),
                    color = if(selectedTab.intValue==0)Color.White else Color.Blue,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 1,
                onClick = { selectedTab.intValue = 1 }) {
                Text(
                    "Talabalar",
                    modifier = Modifier.padding(12.dp),
                    color = if(selectedTab.intValue==1)Color.White else Color.Blue,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 2, onClick = { selectedTab.intValue = 2 }) {
                Text(
                    "O'qituvchilar",
                    color = if(selectedTab.intValue==2)Color.White else Color.Blue,
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 3, onClick = { selectedTab.intValue = 3 }) {
                Text(
                    "Otm ro`yxati",
                    color = if(selectedTab.intValue==3)Color.White else Color.Blue,
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 4, onClick = { selectedTab.intValue = 4 }) {
                Text(
                    "Jadvallar",
                    color = if(selectedTab.intValue==4)Color.White else Color.Blue,
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        when (selectedTab.intValue) {
            0 -> OliyTalimUmumiyTab(viewmodel = umumitViewModel)
            1 -> OliyTalimStudentTab()
            2 -> OliyTalimTeacherTab()
            3 -> OliyTalimOtmTab(oliyTalimOtmViewModel)
            4 -> OliyTalimTableTab()
        }
    }
}