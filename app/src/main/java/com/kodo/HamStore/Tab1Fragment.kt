package com.kodo.HamStore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class Tab1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = activity as Context
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    lateinit var mContext:Context
    lateinit var et:EditText
    lateinit var tv:TextView
    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et= view.findViewById(R.id.et)
        tv= view.findViewById(R.id.tv)
        recyclerView = view.findViewById(R.id.recycler)

        Search.Companion.naverShopping(
            mContext,
            "도롱뇽",
            recyclerView
        )

        view.findViewById<Button>(R.id.btn).setOnClickListener {
            //tv.setText(et.getText().toString())
            var query:String = et.text.toString()
            tv.text= query
            et.setText("")

            Search.Companion.naverShopping(
                mContext,
                query,
                recyclerView
            )

        }

        et.setOnEditorActionListener { textView, i, keyEvent ->
            tv.text= textView.text
            et.setText("")
            true
        }

    }



}