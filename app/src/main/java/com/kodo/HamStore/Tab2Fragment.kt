package com.kodo.HamStore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class Tab2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = activity as Context
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }
    lateinit var mContext: Context
    lateinit var recyclerview1:RecyclerView
    lateinit var recyclerview2:RecyclerView
    lateinit var recyclerview3:RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview1= view.findViewById(R.id.recycler1)
        recyclerview2= view.findViewById(R.id.recycler2)
        recyclerview3= view.findViewById(R.id.recycler3)

        //네이버 검색 API 사용
        Search.Companion.naverShopping(mContext, "햄스터 리빙박스", recyclerview1)
        Search.Companion.naverShopping(mContext,"햄스터 나무집", recyclerview2)
        Search.Companion.naverShopping(mContext,"햄스터 바닥재", recyclerview3)
    }
    
    //프레그먼트 객체가 처음 만들어질때 딱 1번 실행되는 메소드
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}