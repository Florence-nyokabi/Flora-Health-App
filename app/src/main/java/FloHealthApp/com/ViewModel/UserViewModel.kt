package FloHealthApp.com.ViewModel

import FloHealthApp.com.model.RegisterRequest
import FloHealthApp.com.model.RegisterResponse
import FloHealthApp.com.repository.UserRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    var userRepo = UserRepository()
    val regLiveData = MutableLiveData<RegisterResponse>()
    val errLiveData = MutableLiveData<String>()

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = userRepo.registerUser(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}