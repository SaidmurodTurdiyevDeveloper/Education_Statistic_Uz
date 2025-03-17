package us.smt.educationstatisticuz.presintation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun DropDown(
    modifier: Modifier = Modifier,
    list: List<String>,
    isOpen: Boolean,
    onOpen: () -> Unit,
    onDismiss: () -> Unit,
    select: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(isOpen) }

    Box(modifier = modifier) {
        IconButton(onClick = {
            expanded = !expanded
            onOpen()
        }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
                onDismiss()
            }
        ) {
            list.forEach { type ->
                DropdownMenuItem(
                    text = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = type,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp
                        )
                    },
                    onClick = {
                        select(type)
                        expanded = false
                        onDismiss()
                    }
                )
            }
        }
    }
}
