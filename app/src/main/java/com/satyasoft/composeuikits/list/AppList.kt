package com.satyasoft.composeuikits.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppList(
    items: List<AppListItem>,
    modifier: Modifier = Modifier,
    showDivider: Boolean = true,
    onClick: (AppListItem) -> Unit = {}
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onClick(item) }
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Start
                ) {

                    // Leading Icon
                    item.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 12.dp)
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {

                        // Title
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleMedium
                        )

                        // Subtitle
                        item.subtitle?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Trailing Icon
                    item.trailing?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Divider
                if (showDivider) {
                    Divider()
                }
            }
        }
    }
}
