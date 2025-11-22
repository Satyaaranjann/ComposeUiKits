package com.satyasoft.composeuikits.list

data class NestedParentItem(
    val title: String,
    val children: List<String>,
    val isExpanded: Boolean = false
)
