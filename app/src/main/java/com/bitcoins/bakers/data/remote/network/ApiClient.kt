package com.bitcoins.bakers.data.remote.network

import com.bitcoins.bakers.constants.Constants
import com.bitcoins.bakers.data.repository.BakerRepoImpl
import com.bitcoins.bakers.presentation.repository.BakerRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideBakerApi(gson:Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.AWSBASEURL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideItemService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideBakerRepository(api:ApiService) : BakerRepo {
        return BakerRepoImpl(api)
    }


}