package com.example.sopt24_week3.Network.Post

import com.example.sopt24_week3.Data.ProductOverviewData

data class GetMainProductListResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<ProductOverviewData>?
)