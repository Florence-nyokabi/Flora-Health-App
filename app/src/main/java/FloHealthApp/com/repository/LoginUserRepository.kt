package FloHealthApp.com.repository

import FloHealthApp.com.api.ApiClient
import FloHealthApp.com.api.ApiInterface
import FloHealthApp.com.model.LoginRequest
import FloHealthApp.com.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginUserRepository {
    val apiClient= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            apiClient.loginUser(loginRequest)
        }
    }
}
