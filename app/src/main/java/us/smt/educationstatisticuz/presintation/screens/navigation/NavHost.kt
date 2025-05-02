package us.smt.educationstatisticuz.presintation.screens.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
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
import us.smt.educationstatisticuz.ui.EducationStatisticUzTheme

const val OLIY_TALIM = "Oliy ta'lim"
const val PROFESSIONAL_TALIM = "Professional ta'lim"
const val QABUL = "Qabul"
const val DOCTARANTURA = "Doktorantura"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val isDarkMode = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableIntStateOf(0) }
    val navController = rememberNavController()
    EducationStatisticUzTheme(
        darkTheme = isDarkMode.value
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 32.dp)
                        .fillMaxHeight()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                        }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                tint = if (isDarkMode.value) Color.White else Color.Black,
                                contentDescription = "Orqaga"
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = getTitle(selectedItem.intValue),
                            color = if (isDarkMode.value) Color.White else Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    NavigationDrawerItem(
                        colors = NavigationDrawerItemDefaults.colors(),
                        label = {
                            Text(OLIY_TALIM)
                        },
                        shape = RoundedCornerShape(4.dp),
                        selected = selectedItem.intValue == 0,
                        onClick = {
                            scope.launch {
                                selectedItem.intValue = 0
                                drawerState.close()
                                navController.navigate(oliyTalimRoute)
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = {
                            Text(PROFESSIONAL_TALIM)
                        },
                        shape = RoundedCornerShape(4.dp),
                        selected = selectedItem.intValue == 1,
                        onClick = {
                            scope.launch {
                                selectedItem.intValue = 1
                                drawerState.close()
                                navController.navigate(professionalTalim)
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = {
                            Text(QABUL)
                        },
                        shape = RoundedCornerShape(4.dp),
                        selected = selectedItem.intValue == 2,
                        onClick = {
                            scope.launch {
                                selectedItem.intValue = 2
                                drawerState.close()
                                navController.navigate(professionalTalim)
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = {
                            Text(DOCTARANTURA)
                        },
                        shape = RoundedCornerShape(4.dp),
                        selected = selectedItem.intValue == 3,
                        onClick = {
                            selectedItem.intValue = 3
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Tungi rejim",
                            color = if (isDarkMode.value) Color.White else Color.Black
                        )
                        Switch(
                            checked = isDarkMode.value,
                            onCheckedChange = {
                                isDarkMode.value = !isDarkMode.value
                            }
                        )
                    }
                }
            },
            content = {
                Scaffold(topBar = {
                    TopAppBar(
                        title = {
                            Text(getTitle(selectedItem.intValue))
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        }
                    )
                }) { innerPadding ->

                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = oliyTalimRoute
                    ) {
                        composable(oliyTalimRoute) {
                            val viewmodel = hiltViewModel<OliyTalimUmumiyTalimViewmodel>()
                            val viewmodel2 = hiltViewModel<OliyTalimOtmViewModel>()
                            OliyTalimScreen(viewmodel, viewmodel2)
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
        )
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