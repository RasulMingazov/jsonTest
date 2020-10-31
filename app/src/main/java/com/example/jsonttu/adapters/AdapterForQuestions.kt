package com.example.jsonttu.adapters

import com.example.jsonttu.R


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonttu.pojo.Question


class AdapterForQuestions( private val values: List<Question>) :
        RecyclerView.Adapter<AdapterForQuestions.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_question, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val question: Question = values[position]
        holder.textOfQuestion?.text = question.text
        holder.recyclerView.apply {
            adapter = AdapterForAnswers(question.answers)
            layoutManager = LinearLayoutManager(holder.itemView.context)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textOfQuestion: TextView? = null
        var recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerViewButton)
        init {
            textOfQuestion = itemView?.findViewById(R.id.questionTextName)
        }
    }
}