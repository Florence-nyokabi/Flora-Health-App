package FloHealthApp.com.api

import FloHealthApp.com.model.LoginRequest
import FloHealthApp.com.model.LoginResponse
import FloHealthApp.com.model.RegisterRequest
import FloHealthApp.com.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun  registerUser (@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/users/login")
    suspend fun loginUser (@Body loginRequest: LoginRequest): Response<LoginResponse>
}