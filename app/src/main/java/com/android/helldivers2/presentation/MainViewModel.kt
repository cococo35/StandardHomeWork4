package com.android.helldivers2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.android.helldivers2.data.StratagemData
import com.android.helldivers2.retrofit.NetWorkClient
import com.android.helldivers2.retrofit.NetWorkInterface
import kotlinx.coroutines.launch

class MainViewModel(private val remoteDataSource: NetWorkInterface): ViewModel() {
    private val _getStratagemLiveData: MutableLiveData<List<StratagemData>> = MutableLiveData()
    val getStratagemLiveData: LiveData<List<StratagemData>> get() = _getStratagemLiveData

    fun getStratagemList(id: Int) = viewModelScope.launch {
        _getStratagemLiveData.value = listOf(remoteDataSource.getSearch(id).data)
    }
}

class MainViewModelFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return MainViewModel(
            NetWorkClient.searchNetWork
        ) as T
    }
}