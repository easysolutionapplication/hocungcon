package com.education.kidfunlearning

import android.app.Application
import android.content.Context
import com.education.kidfunlearning.di.AppComponent
import com.education.kidfunlearning.di.AppModule
import com.education.kidfunlearning.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import com.squareup.leakcanary.LeakCanary

class KidLearningApplication :Application() {

    lateinit var component: AppComponent

    fun getAppComponent(): AppComponent {
        return component
    }

    companion object {
        lateinit var instance: KidLearningApplication private set
    }
    operator fun get(context: Context): KidLearningApplication {
        return context.applicationContext as KidLearningApplication
    }



    override fun onCreate() {
        super.onCreate()
        instance = this
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        //
        // DI
        //
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)

        AndroidThreeTen.init(this)
        LeakCanary.install(this)
    }
}