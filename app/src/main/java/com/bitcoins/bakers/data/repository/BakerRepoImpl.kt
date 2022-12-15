package com.bitcoins.bakers.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bitcoins.bakers.data.remote.dto.baker
import com.bitcoins.bakers.data.remote.network.ApiService
import com.bitcoins.bakers.presentation.repository.BakerRepo
import javax.inject.Inject

class BakerRepoImpl @Inject constructor(private val api: ApiService) :BakerRepo {
    val items = MutableLiveData<baker>()

    override suspend fun getItems(): baker? {
        return try {
            api.getItems()
        } catch (e:Exception){
            null
        }
    }
}