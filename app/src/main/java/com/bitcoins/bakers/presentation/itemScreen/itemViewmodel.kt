package com.bitcoins.bakers.presentation.itemScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bitcoins.bakers.data.remote.dto.baker
import com.bitcoins.bakers.data.repository.BakerRepoImpl
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class itemViewmodel(private val bakerRepoImpl: BakerRepoImpl):ViewModel() {

    val items = MutableLiveData<baker>()

    val works = MutableLiveData<Boolean>()

    fun getItems() = viewModelScope.launch {
        items.value = bakerRepoImpl.getItems()

        works.value = items.value != null
    }

}