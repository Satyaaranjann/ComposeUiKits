package com.satyasoft.composeuikits.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StickyHeaderList(
    grouped: Map<String, List<SimpleItem>>,
    modifier: Modifier = Modifier,
    onItemClick: (SimpleItem) -> Unit = {}
) {
    LazyColumn(modifier = modifier) {
        grouped.forEach { (header, items) ->
            item(key = "header_$header") {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = header,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )
            }
            items(items, key = { it.id }) { item ->
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                ) {
                    Text(item.title, style = MaterialTheme.typography.bodyLarge, modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clickable { onItemClick(item) })
                }
            }
        }
    }
}