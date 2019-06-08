package com.example.sopt24_week3.Network.Post

data class PostLoginResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: String?
)