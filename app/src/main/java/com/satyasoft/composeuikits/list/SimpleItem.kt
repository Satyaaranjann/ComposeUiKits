package com.satyasoft.composeuikits.list

import androidx.compose.ui.graphics.vector.ImageVector

data class SimpleItem(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val icon: ImageVector? = null,
    val extra: String? = null
)