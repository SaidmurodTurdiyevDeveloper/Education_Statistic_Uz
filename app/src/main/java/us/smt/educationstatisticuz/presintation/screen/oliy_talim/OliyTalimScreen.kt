package us.smt.educationstatisticuz.presintation.screen.oliy_talim

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import us.smt.educationstatisticuz.presintation.component.CircularDiagram
import us.smt.educationstatisticuz.presintation.component.UzbekistanMap
import us.smt.educationstatisticuz.presintation.component.VerticalDiagram
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramData
import us.smt.educationstatisticuz.model.DiagramDataWithColor

const val oliyTalim = "Oliy talim"

@Composable
fun OliyTalimScreen() {
    val selectedTab = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ScrollableTabRow(
            selectedTabIndex = selectedTab.value
        ) {
            Tab(selected = selectedTab.value == 0, onClick = { selectedTab.value = 0 }) {
                Text(
                    "Umumiy",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.value == 1, onClick = { selectedTab.value = 1 }) {
                Text(
                    "Talabalar",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.value == 2, onClick = { selectedTab.value = 2 }) {
                Text(
                    "O'qituvchilar",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.value == 3, onClick = { selectedTab.value = 3 }) {
                Text(
                    "Otm ro`yxati",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Tab(selected = selectedTab.value == 4, onClick = { selectedTab.value = 4 }) {
                Text(
                    "Jadvallar",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        when (selectedTab.value) {
            0 -> UmumiyTab()
            1 -> TalabalarTab()
            2 -> TeacherTab()
            3 -> OtmTab()
            4 -> TableTab()
        }
    }
}

@Composable
fun UmumiyTab(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "OTMlar soni: 208",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "Professor-o'qituvchilar soni: 44911",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "Talabalar soni: 1531566",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

        item {
            CircularDiagram(
                data = CommonDiagramData(
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
                )
            )
        }
        item {
            VerticalDiagram(
                color = Color(0xFFA1DD75),
                count = 4,
                data = CommonDiagramData(
                    title = "OTMlar soni tashkiliy turi bo`yicha",
                    types = mapOf(
                        "All" to listOf(
                            DiagramData(
                                name = "Konservatoriya",
                                value = 1,
                            ),
                            DiagramData(
                                name = "Akademiya",
                                value = 5,
                            ),
                            DiagramData(
                                name = "Filial",
                                value = 40
                            ),
                            DiagramData(
                                name = "Institut",
                                value = 53,
                            ),
                            DiagramData(
                                name = "Universitet",
                                value = 109,
                            )
                        )
                    )
                )
            )
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    UzbekistanMap()
                }
            }
        }

        item {
            CircularDiagram(
                data = CommonDiagramData(
                    title = "Talabalar soni jins kesimida",
                    types = mapOf(
                        "Jami" to listOf(
                            DiagramDataWithColor(
                                name = "Erkaklar",
                                value = 724275,
                                color = Color(0xFF4DA2F1)
                            ),
                            DiagramDataWithColor(
                                name = "Ayollar",
                                value = 807291,
                                color = Color(0xFFFF6482)
                            )
                        ),
                        "Davlat" to listOf(
                            DiagramDataWithColor(
                                name = "Erkaklar",
                                value = 494737,
                                color = Color(0xFF4DA2F1)
                            ),
                            DiagramDataWithColor(
                                name = "Ayollar",
                                value = 486641,
                                color = Color(0xFFFF6482)
                            )
                        ),
                        "Nodavlat" to listOf(
                            DiagramDataWithColor(
                                name = "Erkaklar",
                                value = 205994,
                                color = Color(0xFF4DA2F1)
                            ),
                            DiagramDataWithColor(
                                name = "Ayollar",
                                value = 304811,
                                color = Color(0xFFFF6482)
                            )
                        ),
                        "Xorijiy" to listOf(
                            DiagramDataWithColor(
                                name = "Erkaklar",
                                value = 23544,
                                color = Color(0xFF4DA2F1)
                            ),
                            DiagramDataWithColor(
                                name = "Ayollar",
                                value = 15839,
                                color = Color(0xFFFF6482)
                            )
                        )
                    )
                )
            )
        }
        item {
            VerticalDiagram(
                color = Color(0xFFA1DD75),
                count = 4,
                paddingStart = 60.dp,
                data = CommonDiagramData(
                    title = "OTMlar soni tashkiliy turi bo`yicha",
                    types = mapOf(
                        "Jami" to listOf(
                            DiagramData(
                                name = "Bakalavr",
                                value = 1488312,
                            ),
                            DiagramData(
                                name = "Magistratura",
                                value = 38097,
                            ),
                            DiagramData(
                                name = "Ordinatura",
                                value = 5157
                            )
                        ),
                        "Davlat" to listOf(
                            DiagramData(
                                name = "Bakalavr",
                                value = 950895,
                            ),
                            DiagramData(
                                name = "Magistratura",
                                value = 25381,
                            ),
                            DiagramData(
                                name = "Ordinatura",
                                value = 5102
                            )
                        ),
                        "Nodavlat" to listOf(
                            DiagramData(
                                name = "Bakalavr",
                                value = 501027,
                            ),
                            DiagramData(
                                name = "Magistratura",
                                value = 9723,
                            ),
                            DiagramData(
                                name = "Ordinatura",
                                value = 55
                            )
                        ),
                        "Xorijiy" to listOf(
                            DiagramData(
                                name = "Bakalavr",
                                value = 36390,
                            ),
                            DiagramData(
                                name = "Magistratura",
                                value = 2993,
                            ),
                            DiagramData(
                                name = "Ordinatura",
                                value = 0
                            )
                        )
                    )
                )
            )
        }
    }
}

@Composable
fun TalabalarTab(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Qilinmoqda")
    }
}

@Composable
fun TeacherTab(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Qilinmoqda")
    }
}

@Composable
fun OtmTab(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Qilinmoqda")
    }
}

@Composable
fun TableTab(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Qilinmoqda")
    }
}

@Preview
@Composable
private fun UmumiyTabPrev() {
    UmumiyTab()
}