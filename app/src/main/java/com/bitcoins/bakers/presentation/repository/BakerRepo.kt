package com.bitcoins.bakers.presentation.repository

import com.bitcoins.bakers.data.remote.dto.baker

interface BakerRepo {

    suspend fun getItems():baker?

}