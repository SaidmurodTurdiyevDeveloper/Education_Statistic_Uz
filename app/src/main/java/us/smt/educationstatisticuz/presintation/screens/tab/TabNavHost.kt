package us.smt.educationstatisticuz.presintation.screens.tab


import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import us.smt.educationstatisticuz.presintation.screens.home.HomeScreen
import us.smt.educationstatisticuz.presintation.screens.home.homeRoute
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.OliyTalimScreen
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.oliyTalimRoute
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.otm_tab.OliyTalimOtmViewModel
import us.smt.educationstatisticuz.presintation.screens.oliy_talim.umuiy_tab.OliyTalimUmumiyTalimViewmodel

const val tabNavHostRoute = "tab_nav_host"

@Composable
fun TabNavHost() {
    val topLevelRoutes = listOf(
        TopLevelRoute("Home", homeRoute, Icons.Default.Home),
        TopLevelRoute("Oliy ta'lim", oliyTalimRoute, Icons.Default.AccountCircle)
    )
    val navController = rememberNavController()

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White, modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                topLevelRoutes.forEach { topLevelRoute ->
                    BottomNavigationItem(
                        icon = { Icon(topLevelRoute.icon, contentDescription = topLevelRoute.name) },
                        label = { Text(topLevelRoute.name) },
                        selected = currentDestination?.hierarchy?.any { it.hasRoute(topLevelRoute.route::class) } == true,
                        onClick = {
                            navController.navigate(topLevelRoute.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        selectedContentColor = Color(0xFF00A708),
                        unselectedContentColor = Color.Gray
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = homeRoute, modifier = Modifier.padding(innerPadding)) {
            composable(route = oliyTalimRoute, content = {
                val viewmodel = hiltViewModel<OliyTalimUmumiyTalimViewmodel>()
                val oliyTalim = hiltViewModel<OliyTalimOtmViewModel>()
                OliyTalimScreen(viewmodel, oliyTalim)
            })
            composable(route = homeRoute, content = {
                HomeScreen()
            })
        }
    }
}

data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: ImageVector)
