package com.satyasoft.composeuikits.appbar

import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    navigationIcon: ImageVector? = null,
    onNavClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = navigationIcon?.let {
            {
                IconButton(onClick = { onNavClick?.invoke() }) {
                    Icon(imageVector = it, contentDescription = "Back")
                }
            }
        }
    )
}
