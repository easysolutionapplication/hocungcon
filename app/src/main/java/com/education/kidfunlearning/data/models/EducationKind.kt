package com.education.kidfunlearning.data.models

/**
 * Created by laivantrach1190@gmail.com
 * Copyright (c) 2020 . All rights reserved.
 */
data class EducationKind (val id: Int, val label: String, val icon: String, val categories: List<Category>)

data class Category(
    val id: Int,
    val name: String,
    val image: String,
    val requiredMinAge: Int,
    val requiredMaxAge: Int,
    val country: List<Country>
)

enum class Country(val code: String) {
    ALL("all"),
    VIETNAM("vn"),
    UK("uk"),
    US("us"),
    JAPAN("jp"),
    KOREA("ko");

    companion object{
        fun find(value: String, exist: Boolean): Country = values().firstOrNull { it.code == value } ?: ALL

        fun find(value: String): List<Country> {
            return value.split(",").map { find(it, false) }
        }
    }
}