package com.bitcoins.bakers.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bitcoins.bakers.data.remote.dto.baker
import com.bitcoins.bakers.data.remote.network.ApiClient
import com.bitcoins.bakers.presentation.repository.BakerRepo

class BakerRepoImpl(
    apiClient : ApiClient,
    application: Application
):BakerRepo {

    private val apiService = apiClient.getApiService(application)
    val items = MutableLiveData<baker>()

    override suspend fun getItems(): baker? {
        try {
            val item = apiService.getItems()
            Log.v("items","$items")
            return item
        }
        catch (e : Exception){
            Log.v("items","Didn't work")
        }
        return null
    }
}