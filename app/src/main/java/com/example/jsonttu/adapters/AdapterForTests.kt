package com.example.jsonttu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonttu.R
import com.example.jsonttu.pojo.Test

class AdapterForTests(private val values: List<Test>) :
        RecyclerView.Adapter<AdapterForTests.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_test, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val test: Test = values[position]
        holder.textOfTest?.text = test.name

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textOfTest: TextView? = null

        init {
            textOfTest = itemView?.findViewById(R.id.testTextName)
        }
    }
}