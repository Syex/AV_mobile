package de.memorian.av.android.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.memorian.av.android.presentation.barcode.BarcodeScanActivity
import de.memorian.av.android.presentation.navigation.Navigator
import de.memorian.gzg.ui.theme.AppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val context = LocalContext.current

            AppTheme {
                Scaffold(
                    bottomBar = { NavigationBar(navController) },
                    floatingActionButtonPosition = FabPosition.Center,
                    isFloatingActionButtonDocked = true,
                    floatingActionButton = {
                        LargeFloatingActionButton(
                            shape = CircleShape,
                            onClick = {
                                startActivity(BarcodeScanActivity.newIntent(context))
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Camera, contentDescription = "Add icon")
                        }
                    }
                ) {

                }
            }
        }
    }

    @Composable
    private fun NavigationBar(navController: NavHostController) {
        NavigationBar {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            Navigator.NavTarget.bottomNavigationTargets.forEach { navTarget ->
                val icon = when (navTarget) {
                    Navigator.NavTarget.ScannedProducts -> Icons.Default.Home
                    Navigator.NavTarget.Settings -> Icons.Default.Settings
                    else -> return@forEach
                }

                NavigationBarItem(
                    icon = { Icon(icon, contentDescription = null) },
                    label = { Text("test") },
                    selected = currentDestination?.hierarchy?.any {
                        it.route == navTarget.label
                    } == true,
                    onClick = {
                        navController.navigate(navTarget.label) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
