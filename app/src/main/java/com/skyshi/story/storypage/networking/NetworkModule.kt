package com.skyshi.story.storypage.networking

import android.app.Application
import com.readystatesoftware.chuck.ChuckInterceptor
import com.skyshi.story.storypage.configuration.Configuration
import com.skyshi.story.storypage.preferences.PreferencesUtil
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule(private val application: Application, internal var cacheFile: File) {
    @Provides
    @Singleton
    internal fun provideCall(preferencesUtil: PreferencesUtil): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        val errorInterceptor = ErrorInterceptor(NetManager(application.applicationContext))

        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(errorInterceptor)
                .addInterceptor(ChuckInterceptor(application.applicationContext))
                .build()

        return Retrofit.Builder()
                .baseUrl(Configuration.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

    @Provides
    @Singleton
    fun providesService(networkService: NetworkService, preferencesUtil: PreferencesUtil): Service {
        return Service(networkService, preferencesUtil)
    }
}