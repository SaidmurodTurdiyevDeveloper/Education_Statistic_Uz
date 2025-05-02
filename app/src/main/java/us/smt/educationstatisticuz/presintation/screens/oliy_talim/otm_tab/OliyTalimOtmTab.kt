package us.smt.educationstatisticuz.presintation.screens.oliy_talim.otm_tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import us.smt.educationstatisticuz.model.University


@Composable
fun OliyTalimOtmTab(viewModel: OliyTalimOtmViewModel) {
    var selectedOwnership by remember { mutableStateOf("Barchasi") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Oliy ta'lim muassasalari ro'yxati", fontWeight = FontWeight.Bold)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            // Dropdown for filtering
            OwnershipFilterDropdown(selectedOwnership) { selectedOwnership = it }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(viewModel.universities.filter {
                selectedOwnership == "Barchasi" || it.ownership == selectedOwnership
            }) { university ->
                UniversityRow(university)
            }
        }
    }
}

@Composable
fun OwnershipFilterDropdown(selected: String, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Barchasi", "Davlat", "Nodavlat")

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        Button(onClick = { expanded = true }) {
            Text(selected)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onSelected(option)
                        expanded = false
                    },
                    text = {
                        Text(option)
                    }
                )
            }
        }
    }
}

@Composable
fun UniversityRow(university: University) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(university.name, modifier = Modifier.weight(1f))
        Text(university.ownership, modifier = Modifier.weight(0.5f))
        Text(university.website, modifier = Modifier.weight(1f))
        Text(university.stats, modifier = Modifier.weight(1f))
    }
}

