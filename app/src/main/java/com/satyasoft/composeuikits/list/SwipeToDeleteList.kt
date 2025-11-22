package com.satyasoft.composeuikits.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeToDeleteListM3(
    items: List<SimpleItem>,
    onDelete: (SimpleItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        items.forEach { item ->

            val scope = rememberCoroutineScope()

            val state = rememberSwipeToDismissBoxState(
                confirmValueChange = { newValue ->
                    if (newValue == SwipeToDismissBoxValue.EndToStart) {
                        scope.launch { onDelete(item) }
                    }
                    true
                }
            )

            SwipeToDismissBox(
                state = state,
                enableDismissFromStartToEnd = false, // only right→left
                backgroundContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.errorContainer)
                            .padding(end = 24.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = MaterialTheme.colorScheme.onErrorContainer
                        )
                    }
                },
                content = {
                    ListItem(
                        headlineContent = { Text(item.title) },
                        supportingContent = {
                            item.subtitle?.let {
                                Text(it)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
            )

            Divider()
        }
    }
}
