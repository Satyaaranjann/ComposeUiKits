package com.satyasoft.composeuikits.chips

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun StatusChip(text: String) {
    AssistChip(
        onClick = {},
        label = { Text(text) }
    )
}
