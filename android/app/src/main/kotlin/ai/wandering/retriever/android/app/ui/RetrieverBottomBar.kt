package ai.wandering.retriever.android.app.ui

import ai.wandering.retriever.android.app.R
import ai.wandering.retriever.android.app.navigation.BottomTabs
import ai.wandering.retriever.android.common.navigation.Screen
import ai.wandering.retriever.android.common.sig.color.Sig
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun RetrieverBottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    fun isSelected(tab: Screen) = currentDestination?.hierarchy?.any { it.route == tab.route } == true

    BottomAppBar(
        actions = {
            BottomTabs.forEach { tab ->
                IconButton(onClick = {
                    navController.navigate(tab.route)
                }) {
                    val icon = if (isSelected(tab)) tab.iconSelected else tab.iconNotSelected
                    Icon(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier.size(28.dp))
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}, shape = CircleShape, containerColor = Sig.ColorScheme.onBackground, contentColor = BottomAppBarDefaults.containerColor) {
                Icon(painterResource(id = R.drawable.edit), null, modifier = Modifier.size(28.dp))
            }
        }
    )
}
