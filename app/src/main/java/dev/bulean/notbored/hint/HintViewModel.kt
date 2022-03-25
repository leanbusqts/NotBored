package dev.bulean.notbored.hint

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bulean.notbored.data.ActivitiesApi
import dev.bulean.notbored.data.DataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HintViewModel() : ViewModel(){

    private val _participantsValue = MutableLiveData<Int>()
    val participantsValue: LiveData<Int> get() = _participantsValue

    private val _priceValue = MutableLiveData<String>()
    val priceValue: LiveData<String> get() = _priceValue

    private val _activityHint = MutableLiveData<String>()
    val activityHint: LiveData<String> get() = _activityHint

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> get() = _progressBar

//    init {
//        getActivity()
//    }
//    getActivityByParticipantsAndType
    fun getActivityByParticipantsAndType(p: Int, t: String){
        viewModelScope.launch {
            try {
                _progressBar.value = true
                val call = withContext(Dispatchers.IO) { ActivitiesApi.retrofitService.getActivityByParticipantsAndType(p, t) }
                if (call.isSuccessful) {
                    _participantsValue.value = call.body()?.participants
                    _priceValue.value = call.body()?.price?.let { getPrice(it) }
                    _activityHint.value = call.body()?.activity
                }

            } catch (e: Exception) {
                Log.e("network", "$e")
            } finally {
                _progressBar.value = false
            }
        }
    }

    fun getRandomActivity(){
        viewModelScope.launch {
            try {
                _progressBar.value = true
                val call = withContext(Dispatchers.IO) { ActivitiesApi.retrofitService.getActivityRandom() }
                if (call.isSuccessful) {
                    _participantsValue.value = call.body()?.participants
                    _priceValue.value = call.body()?.price?.let { getPrice(it) }
                    _activityHint.value = call.body()?.activity
                }

            } catch (e: Exception) {
                Log.e("network", "$e")
            } finally {
                _progressBar.value = false
            }
        }
    }

    private fun getPrice(dPrice: Double) : String {
        return when {
            dPrice == 0.0 -> "Free"
            dPrice < 0.3 -> "Low"
            dPrice < 0.6 -> "Medium"
            else -> "High"
        }
    }

//    fun ranp() : Int {
//        return (1..9).random()
//    }
//    fun rant() : String {
//        return DataSource().loadData().random()
//    }

}