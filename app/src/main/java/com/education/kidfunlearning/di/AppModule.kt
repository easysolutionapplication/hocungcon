package com.education.kidfunlearning.di

import android.app.Application
import com.education.kidfunlearning.data.KidLearningServiceApi
import com.education.kidfunlearning.data.NetworkInterceptor
import com.education.kidfunlearning.data.Repository
import com.education.kidfunlearning.data.RepositoryImpl
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {



    @Provides
    @Singleton
    fun networkInterceptor(app: Application): NetworkInterceptor {
        return NetworkInterceptor(app)
    }

    @Provides
    fun app(): Application {
        return app
    }

    @Provides
    @Singleton
    fun networkServiceApi(app: Application, photoInterceptor: NetworkInterceptor): KidLearningServiceApi {

        val client = OkHttpClient.Builder()
            .addInterceptor(photoInterceptor)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(KidLearningServiceApi.END_POINT_API)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(KidLearningServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun networkRepository(app: Application, serviceApi: KidLearningServiceApi): Repository {
        return RepositoryImpl(serviceApi)
    }

}