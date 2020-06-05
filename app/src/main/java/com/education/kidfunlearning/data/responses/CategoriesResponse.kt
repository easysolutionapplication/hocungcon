package com.education.kidfunlearning.data.responses

data class CategoriesResponse(
    val kind: KindResponse,
    val categories: List<CategoryResponse>
)

sealed class KindResponse(val id: String, val label: String, val image: String)

sealed class CategoryResponse(
    val id: String,
    val label: String,
    val image: String,
    val requiredMinAge: Int,
    val requiredMaxAge: Int,
    val country: String,
    val kind: String
)
