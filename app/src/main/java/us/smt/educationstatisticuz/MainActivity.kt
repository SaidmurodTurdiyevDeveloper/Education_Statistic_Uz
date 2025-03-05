package us.smt.educationstatisticuz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import us.smt.educationstatisticuz.ui.theme.EducationStatisticUzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreen() {
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
                                tint = if(isDarkMode.value) Color.White else Color.Black,
                                contentDescription = "Orqaga"
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Mening Ilovam",
                            color = if(isDarkMode.value) Color.White else Color.Black,
                            fontSize = 20.sp, fontWeight = FontWeight.Bold
                        )
                    }
                    NavigationDrawerItem(
                        colors = NavigationDrawerItemDefaults.colors(),
                        label = {
                            Text("Oliy ta'lim")
                        },
                        shape = RoundedCornerShape(4.dp),
                        selected = selectedItem.intValue == 0,
                        onClick = {
                            scope.launch {
                                navController.navigate(oliyTalim)
                                selectedItem.intValue = 0
                                drawerState.close()
                                navController.navigate(oliyTalim)
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = {
                            Text("Professional ta'lim")
                        },
                        shape = RoundedCornerShape(4.dp),
                        selected = selectedItem.intValue == 1,
                        onClick = {
                            scope.launch {
                                navController.navigate(professionalTalim)
                                selectedItem.intValue = 1
                                drawerState.close()
                                navController.navigate(professionalTalim)
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = {
                            Text("Qabul")
                        },
                        shape = RoundedCornerShape(4.dp),
                        selected = selectedItem.intValue == 2,
                        onClick = {
                            scope.launch {
                                navController.navigate(professionalTalim)
                                selectedItem.intValue = 2
                                drawerState.close()
                                navController.navigate(professionalTalim)
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = {
                            Text("Doktorantura")
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
                        Text("Tungi rejim", color = if(isDarkMode.value) Color.White else Color.Black)
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
                            Text("Mening Ilovam")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "mENU"
                                )
                            }
                        }
                    )
                }) { innerPadding ->

                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = oliyTalim
                    ) {
                        composable(oliyTalim) {
                            OliyTalimScreen()
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
