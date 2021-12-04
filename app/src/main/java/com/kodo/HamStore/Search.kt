package com.kodo.HamStore

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class Search {
    companion object {
        fun naverShopping(context: Context, query: String, recyclerView: RecyclerView) {

            //레트로핏 네트워크 작업 시작!
            val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://openapi.naver.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()

            retrofit.create(NaverRetrofitService::class.java)
                .searchData(query).enqueue(object : Callback<NaverShoppingApiResponse> {
                    override fun onResponse(
                        call: Call<NaverShoppingApiResponse>,
                        response: Response<NaverShoppingApiResponse>
                    ) {

                        val shoppingApiResponse: NaverShoppingApiResponse? = response.body()

                        //아답터 만들어서 리사이클러뷰에 보이기
                        shoppingApiResponse?.let {
                            recyclerView.adapter = MyAdapter(context, it.items)
                        }

                    }

                    override fun onFailure(call: Call<NaverShoppingApiResponse>, t: Throwable) {
                        Toast.makeText(context, "서버오류", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}