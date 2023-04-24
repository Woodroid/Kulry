package com.kulry.data.data

data class SectionWithProduct(
    val title: String,
    val id: String,
    val type: String,
    val url: String,
    val products: List<Product>
)