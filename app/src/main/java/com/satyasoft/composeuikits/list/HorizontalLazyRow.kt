package com.satyasoft.composeuikits.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalLazyRow(
    itemsList: List<SimpleItem>,
    modifier: Modifier = Modifier,
    itemWidthDp: Int = 140,
    onItemClick: (SimpleItem) -> Unit = {}
) {
    LazyRow(modifier = modifier.padding(8.dp)) {
        items(itemsList) { item ->
            Card(
                modifier = Modifier
                    .width(itemWidthDp.dp)
                    .padding(8.dp)
                    .clickable { onItemClick(item) }
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(item.title, style = MaterialTheme.typography.titleMedium)
                    item.subtitle?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                }
            }
        }
    }
}
