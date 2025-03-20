package us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramType
import us.smt.educationstatisticuz.presintation.component.CircularDiagram
import us.smt.educationstatisticuz.presintation.component.HorizontalScreen
import us.smt.educationstatisticuz.presintation.component.UzbekistanMap
import us.smt.educationstatisticuz.presintation.component.VerticalDiagram

@Composable
fun OliyTalimUmumiyTab(
    viewmodel: OliyTalimUmumiyTalimViewmodel
) {
    val state = viewmodel.state.collectAsState()
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
                    text = "OTMlar soni: ${state.value.allOTMCount}",
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
                    text = "Professor-o'qituvchilar soni: ${state.value.allProfessorCount}",
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
                    text = "Talabalar soni: ${state.value.allStudentCount}",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        items(state.value.common) {
            ItemDiagram(it)
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
                    UzbekistanMap(map = state.value.map)
                }
            }
        }
        items(state.value.students) {
            ItemDiagram(it)
        }
        items(state.value.professor) {
            ItemDiagram(it)
        }
    }
}

@Composable
fun ItemDiagram(
    commonDiagramData: CommonDiagramData
) {
    when (commonDiagramData.type) {
        DiagramType.CIRCULAR -> CircularDiagram(
            data = commonDiagramData
        )

        DiagramType.VERTICAL -> VerticalDiagram(
            color = commonDiagramData.color,
            count = commonDiagramData.count,
            paddingStart = commonDiagramData.paddingStart.dp,
            data = commonDiagramData
        )

        DiagramType.HORIZONTAL -> HorizontalScreen(
            color = commonDiagramData.color,
            count = commonDiagramData.count,
            paddingStart = commonDiagramData.paddingStart.dp,
            data = commonDiagramData
        )
    }
}


