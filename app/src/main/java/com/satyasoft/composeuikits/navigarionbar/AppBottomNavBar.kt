package com.satyasoft.composeuikits.navigarionbar


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox

@Composable
fun AppBottomNavBar(
    items: List<NavBarItem>,
    selectedRoute: String,
    onItemSelected: (NavBarItem) -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.primary,
) {
    NavigationBar(
        containerColor = containerColor,
        contentColor = contentColor,
        modifier = modifier
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = selectedRoute == item.route,
                onClick = { onItemSelected(item) },
                icon = {
                    BadgedBox(
                        badge = {
                            item.badgeCount?.let {
                                Badge {
                                    Text("$it")
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (selectedRoute == item.route)
                                item.selectedIcon ?: item.icon
                            else item.icon,
                            contentDescription = item.label
                        )
                    }
                },
                label = { Text(text = item.label) },
                alwaysShowLabel = true
            )
        }
    }
}
