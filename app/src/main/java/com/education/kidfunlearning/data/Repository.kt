package com.education.kidfunlearning.data

import com.education.kidfunlearning.data.models.EducationKind
import io.reactivex.Single

/**
 * Created by laivantrach1190@gmail.com
 * Copyright (c) 2020 . All rights reserved.
 */
interface Repository {

    fun getCategories(): Single<EducationKind>

}