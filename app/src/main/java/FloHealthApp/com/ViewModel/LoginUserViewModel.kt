package FloHealthApp.com.ViewModel

import FloHealthApp.com.model.LoginRequest
import FloHealthApp.com.model.LoginResponse
import FloHealthApp.com.repository.LoginUserRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginUserViewModel: ViewModel() {
    var  userLoginRepo = LoginUserRepository()
    val regLiveData = MutableLiveData<LoginResponse>()
    var errLiveData = MutableLiveData<String>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userLoginRepo.loginUser(loginRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}