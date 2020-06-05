package com.education.kidfunlearning.di

import android.app.Application
import com.education.kidfunlearning.data.KidLearningServiceApi
import com.education.kidfunlearning.data.NetworkInterceptor
import com.education.kidfunlearning.data.Repository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: Application)

    fun repository(): Repository

    fun kidLearningServiceApi(): KidLearningServiceApi

    fun networkInterceptor(): NetworkInterceptor
}