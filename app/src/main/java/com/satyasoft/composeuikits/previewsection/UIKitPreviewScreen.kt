package com.satyasoft.composeuikits.previewsection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satyasoft.composeuikits.buttons.IconPrimaryButton
import com.satyasoft.composeuikits.buttons.OutlineButton
import com.satyasoft.composeuikits.buttons.PrimaryButton
import com.satyasoft.composeuikits.buttons.SecondaryButton
import com.satyasoft.composeuikits.buttons.ToggleButton
import com.satyasoft.composeuikits.list.GridList
import com.satyasoft.composeuikits.list.SimpleItem
import com.satyasoft.composeuikits.list.SwipeToDeleteListM3
import com.satyasoft.composeuikits.theme.UIKitTheme

@Composable
fun UIKitPreviewScreen() {
    UIKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            PreviewSection("Primary Button") {
                PrimaryButton(
                    text = "Primary Button",
                    onClick = {}
                )
            }

            PreviewSection("Secondary Button") {
                SecondaryButton(
                    text = "Secondary Button",
                    onClick = {}
                )
            }

            PreviewSection("Outline Button") {
                OutlineButton(
                    text = "Outline Button",
                    onClick = {}
                )
            }

            PreviewSection("Icon Primary Button") {
                IconPrimaryButton(
                    text = "Send",
                    icon = Icons.Default.Send,
                    onClick = {}
                )
            }

            PreviewSection("Toggle Button") {
                ToggleButton(
                    checked = true,
                    text = "Active",
                    onCheckedChange = {}
                )
            }

            PreviewSection("Grid List") {
                Box(modifier = Modifier.height(200.dp)) { // bounded height
                    GridList(
                        itemsList = listOf(
                            SimpleItem("Item 1", "Subtitle 1"),
                            SimpleItem("Item 2", "Subtitle 2")
                        ),
                        columns = 2
                    )
                }
            }

            PreviewSection("Swipe to Delete List (Material 3)") {
                Box(modifier = Modifier.height(150.dp)) { // bounded height
                    SwipeToDeleteListM3(
                        items = listOf(
                            SimpleItem("Swipe Me", "Delete"),
                            SimpleItem("Item 2", "Subtitle")
                        ),
                        onDelete = {}
                    )
                }
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun UIKitPreviewScreenPreview() {
    UIKitPreviewScreen()
}