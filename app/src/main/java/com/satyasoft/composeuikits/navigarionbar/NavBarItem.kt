package com.satyasoft.composeuikits.navigarionbar

import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector? = null,
    val badgeCount: Int? = null,
    val route: String
)
