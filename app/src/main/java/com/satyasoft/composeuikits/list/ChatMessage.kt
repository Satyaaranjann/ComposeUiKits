package com.satyasoft.composeuikits.list

data class ChatMessage(
    val id: String,
    val text: String,
    val isMine: Boolean = false
)