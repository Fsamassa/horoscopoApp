package com.example.horoscopoapp.data.network

import com.example.horoscopoapp.data.RepositorioImpl
import com.example.horoscopoapp.data.core.interceptor.AuthInterceptor
import com.example.horoscopoapp.domain.Repositorio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app/")
            .client(okHttpClient)    // <- Interceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    // Interceptor -> Me indica en el log info cuando hago accesos a la API externa
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideHoroscopoApiService(retrofit: Retrofit):HoroscopoApiService{
        return retrofit.create(HoroscopoApiService::class.java)
    }
    @Provides
    fun provideRepositorio(apiService: HoroscopoApiService):Repositorio{
        return RepositorioImpl(apiService)
    }
}