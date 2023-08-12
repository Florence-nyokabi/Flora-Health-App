package FloHealthApp.com.repository

import FloHealthApp.com.api.ApiClient
import FloHealthApp.com.api.ApiInterface
import FloHealthApp.com.model.RegisterRequest
import FloHealthApp.com.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return withContext(Dispatchers.IO){
            apiClient.registerUser(registerRequest)
        }
    }
}