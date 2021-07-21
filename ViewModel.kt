package live.patrick.networkcall.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import live.patrick.networkcall.api.RetrofitProvider
import live.patrick.networkcall.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val usersLiveData = MutableLiveData<List<User>>()

    fun getUsers(){
        viewModelScope.launch {
            usersLiveData.postValue(RetrofitProvider.placeHolderAPI.getUsers())
        }
    }
}