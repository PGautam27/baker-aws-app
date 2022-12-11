package com.bitcoins.bakers.data.remote.network

import com.bitcoins.bakers.constants.Constants
import com.bitcoins.bakers.data.remote.dto.baker
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.GETURL)
    suspend fun getItems() : baker

}