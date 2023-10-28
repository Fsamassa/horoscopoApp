package com.example.horoscopoapp.data.network

import com.example.horoscopoapp.data.RepositorioImpl
import com.example.horoscopoapp.domain.Repositorio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
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