package us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.fuqorolik.Fuqorolik
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.hudud.Hudud
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.kurslar.Kurslar
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.talim_shakli.TalimShakli
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.talim_turi.TalimTuri
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.tolov_shakli.TolovShakli
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.yashash_joyi.YashashJoyi
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.student_tab.yoshi.Yoshi

@Composable
fun OliyTalimStudentTab(modifier: Modifier = Modifier) {
    val selectedTab = remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScrollableTabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTab.intValue
        ) {
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 0,
                onClick = { selectedTab.intValue = 0 }) {
                Text(
                    "Ta`lim turi",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 1, onClick = { selectedTab.intValue = 1 }) {
                Text(
                    "Ta`lim shakli",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 2, onClick = { selectedTab.intValue = 2 }) {
                Text(
                    "To`lov shakli",
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
                    "Fuqorolik",
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
                    "Kurslar",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 5, onClick = { selectedTab.intValue = 5 }) {
                Text(
                    "Yoshi",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 6, onClick = { selectedTab.intValue = 6 }) {
                Text(
                    "Yashash joyi",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .zIndex(10f),
                selected = selectedTab.intValue == 7, onClick = { selectedTab.intValue = 7 }) {
                Text(
                    "Hududlar kesimi",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

        when (selectedTab.intValue) {
            0 -> TalimTuri()
            1 -> TalimShakli()
            2 -> TolovShakli()
            3 -> Fuqorolik()
            4 -> Kurslar()
            5 -> Yoshi()
            6 -> YashashJoyi()
            else -> Hudud()
        }
    }
}

@Preview
@Composable
private fun OliyTalimStudentTabPrev() {
    OliyTalimStudentTab()
}