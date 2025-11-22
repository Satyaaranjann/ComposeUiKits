package com.satyasoft.composeuikits.list

import androidx.compose.ui.graphics.vector.ImageVector

data class AppListItem(
    val title: String,
    val subtitle: String? = null,
    val icon: ImageVector? = null,
    val trailing: ImageVector? = null
)
