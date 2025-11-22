package com.satyasoft.composeuikits.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatStyleList(
    messages: List<ChatMessage>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(messages, key = { it.id }) { msg ->
            Row(
                horizontalArrangement = if (msg.isMine) Arrangement.End else Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = if (msg.isMine) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                    tonalElevation = 2.dp
                ) {
                    Text(
                        text = msg.text,
                        modifier = Modifier
                            .padding(12.dp)
                            .widthIn(max = 280.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (msg.isMine) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
