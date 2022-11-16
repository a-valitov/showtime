package com.avalitov.showtime.pages.populars

import androidx.lifecycle.MutableLiveData
import com.avalitov.showtime.common.BaseViewModel
import java.util.Date

class PopularsViewModel : BaseViewModel() {
    var timeState : MutableLiveData<Date> = MutableLiveData()

    init {
        timeState.value = Date()
    }
}