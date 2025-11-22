package com.satyasoft.composeuikits.list

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NestedList(
    items: List<NestedParentItem>,
    modifier: Modifier = Modifier,
    onChildClick: (String) -> Unit = {},
    onParentExpand: (Int, Boolean) -> Unit = { _, _ -> }
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(), // Prevent infinite height crash
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items) { index, parent ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onParentExpand(index, !parent.isExpanded) }
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = parent.title,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Icon(
                            imageVector = if (parent.isExpanded)
                                Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                            contentDescription = if (parent.isExpanded) "Collapse" else "Expand"
                        )
                    }

                    AnimatedVisibility(
                        visible = parent.isExpanded,
                        enter = expandVertically() + fadeIn(),
                        exit = shrinkVertically() + fadeOut()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(start = 24.dp, bottom = 12.dp)
                        ) {
                            parent.children.forEach { child ->
                                Text(
                                    text = child,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { onChildClick(child) }
                                        .padding(vertical = 6.dp),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
