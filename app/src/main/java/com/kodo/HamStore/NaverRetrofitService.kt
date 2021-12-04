package com.kodo.HamStore

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverRetrofitService {

    @Headers("X-Naver-Client-Id: XjIlHKsPGN3bqnUffAeK","X-Naver-Client-Secret: g4a7Rc9BQV")
    @GET("/v1/search/shop.json")
    fun searchDataString(@Query("query") query:String):Call<String>


    @Headers("X-Naver-Client-Id: XjIlHKsPGN3bqnUffAeK","X-Naver-Client-Secret: g4a7Rc9BQV")
    @GET("/v1/search/shop.json")
    fun searchData(@Query("query") query:String):Call<NaverShoppingApiResponse>



}