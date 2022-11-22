package com.avalitov.showtime.pages.populars

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.avalitov.showtime.common.BaseViewModel
import com.avalitov.showtime.network.WebRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularsViewModel(private val webRepo: WebRepository) : BaseViewModel() {
    var rates : MutableLiveData<Map<String, Double>> = MutableLiveData()

    companion object {
        private const val TAG = "POPULARS_VM"
    }

    init {
        getLatestRates()
    }

    private fun getLatestRates() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val ratesMap = webRepo.loadRates()
                withContext(Dispatchers.Main) {
                    rates.value = ratesMap
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "Could not get exchange rates from server.")
            e.printStackTrace()
        }
    }
}