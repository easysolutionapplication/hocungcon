package com.education.kidfunlearning.data

import com.education.kidfunlearning.data.models.Category
import com.education.kidfunlearning.data.models.Country
import com.education.kidfunlearning.data.models.EducationKind
import io.reactivex.Single

/**
 * Created by laivantrach1190@gmail.com
 * Copyright (c) 2020 . All rights reserved.
 */
class RepositoryImpl(private val serviceApi: KidLearningServiceApi): Repository {
    override fun getCategories(): Single<EducationKind> {
        return serviceApi.getCategories().map {
            EducationKind(it.kind.id.toInt(), it.kind.label, it.kind.image,
                    it.categories.map {category ->
                        Category(
                            category.id.toInt(),
                            category.label,
                            category.image,
                            category.requiredMinAge,
                            category.requiredMaxAge,
                            Country.find(category.country)
                        )
                    }
                )
        }
    }

}