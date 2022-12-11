package com.bitcoins.bakers.presentation.itemScreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcoins.bakers.data.remote.network.ApiClient
import com.bitcoins.bakers.data.repository.BakerRepoImpl


class itemViewModelFactory(private val application: Application): ViewModelProvider.Factory {

    @Suppress("NOT_CHECKED")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(itemViewmodel::class.java)){
            return itemViewmodel(
                bakerRepoImpl = BakerRepoImpl(
                    apiClient = ApiClient,
                    application = application
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}