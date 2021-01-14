package com.hussainalmahdi.android.challenge.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hussainalmahdi.android.challenge.RemoteSource.DataFetcher
import com.hussainalmahdi.android.challenge.RemoteSource.Senator

class SenatorsListViewModel:ViewModel() {
        var senatorsListLiveData: LiveData<List<Senator>> = DataFetcher().fetchData()
}