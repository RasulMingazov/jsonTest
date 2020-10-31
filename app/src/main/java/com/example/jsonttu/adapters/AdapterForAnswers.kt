package com.example.jsonttu.adapters

import com.example.jsonttu.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonttu.pojo.Answer

class AdapterForAnswers(private val values: List<Answer>) :
        RecyclerView.Adapter<AdapterForAnswers.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclereview_button, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int { return values.size }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val answer: Answer = values[position]
        holder.button?.text = answer.text
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var button: RadioButton? = null
        init {
            button = itemView?.findViewById(R.id.buttonR)
        }
    }

}