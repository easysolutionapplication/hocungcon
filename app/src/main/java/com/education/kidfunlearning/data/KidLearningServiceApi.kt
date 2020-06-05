package com.education.kidfunlearning.data

import com.education.kidfunlearning.data.responses.CategoriesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface KidLearningServiceApi {
    @GET("category/")
    fun getCategories(): Single<CategoriesResponse>

    companion object{
        const val END_POINT_API = "http://api.laitrach.com:8080/category"
    }
}