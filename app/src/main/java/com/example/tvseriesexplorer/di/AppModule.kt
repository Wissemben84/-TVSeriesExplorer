package com.example.tvseriesexplorer.di

import com.example.tvseriesexplorer.data.TvSeriesApi
import com.example.tvseriesexplorer.data.TvSeriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.episodate.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTvSeriesApi(retrofit: Retrofit): TvSeriesApi {
        return retrofit.create(TvSeriesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTvSeriesRepository(api: TvSeriesApi): TvSeriesRepository {
        return TvSeriesRepository(api)
    }
}
