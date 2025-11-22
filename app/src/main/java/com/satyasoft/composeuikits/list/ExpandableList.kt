package com.satyasoft.composeuikits.list

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableList(
    groups: List<Pair<String, List<SimpleItem>>>,
    modifier: Modifier = Modifier,
    initiallyExpanded: Set<String> = emptySet(),
    onChildClick: (parentTitle: String, child: SimpleItem) -> Unit = { _, _ -> },
    showDivider: Boolean = true
) {
    var expandedSet by remember { mutableStateOf(initiallyExpanded.toMutableSet()) }

    LazyColumn(modifier = modifier) {

        groups.forEach { (parent, children) ->

            item(key = "header_$parent") {

                // Add Material Card for parent item
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {

                    Column {

                        // Arrow rotation animation
                        val rotation by animateFloatAsState(
                            targetValue = if (expandedSet.contains(parent)) 180f else 0f,
                            label = ""
                        )

                        // Parent Header Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (expandedSet.contains(parent))
                                        expandedSet.remove(parent)
                                    else
                                        expandedSet.add(parent)
                                }
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = parent,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Icon(
                                imageVector = Icons.Default.ExpandMore,
                                contentDescription = null,
                                modifier = Modifier.rotate(rotation) // animated arrow
                            )
                        }

                        // Expandable Children Section
                        AnimatedVisibility(
                            visible = expandedSet.contains(parent),
                            enter = expandVertically() + fadeIn(),
                            exit = shrinkVertically() + fadeOut()
                        ) {

                            Column(
                                modifier = Modifier.padding(start = 12.dp, end = 8.dp, bottom = 8.dp)
                            ) {

                                children.forEachIndexed { index, child ->

                                    ListItem(
                                        headlineContent = { Text(child.title) },
                                        supportingContent = {
                                            child.subtitle?.let { Text(it) }
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { onChildClick(parent, child) }
                                    )

                                    // Divider only if NOT last child
                                    if (showDivider && index < children.lastIndex)
                                        Divider()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
