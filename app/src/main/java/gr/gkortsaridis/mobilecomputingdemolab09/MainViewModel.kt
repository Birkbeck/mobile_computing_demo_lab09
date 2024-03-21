package gr.gkortsaridis.mobilecomputingdemolab09

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _jokes = MutableLiveData<List<Joke>>()
    val jokes: LiveData<List<Joke>> = _jokes

    private var dataRepository: DataRepository? = null

    fun setupRepository(dataRepository: DataRepository) {
        this.dataRepository = dataRepository
    }

    fun retrieveJokes() = viewModelScope.launch {
        dataRepository?.let {
            val jokes = it.retrieveJokes()
            _jokes.value = jokes
        }
    }
}