package com.example.sopt24_week3.Network

import com.example.sopt24_week3.Network.Post.GetMainProductListResponse
import com.example.sopt24_week3.Network.Post.PostLoginResponse
import com.example.sopt24_week3.Network.Post.PostSignupResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @POST("/api/auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type: String, //헤더에 들어갈 건 String 타입의 content_type이라는 변수명을 가짐
        @Body() body: JsonObject
    ): Call<PostLoginResponse> //요청을 보낸 다음 응답을 받을 그릇->PostLoginResponse

    @POST("/api/auth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type: String,
        @Body() body:JsonObject
    ): Call<PostSignupResponse>

    @GET("/api/webtoons/main/{flag}")
    fun getMainProductListResponse(
        @Header("Content-Type") content_type: String,
        @Path("flag") flag: Int
    ): Call<GetMainProductListResponse>
}