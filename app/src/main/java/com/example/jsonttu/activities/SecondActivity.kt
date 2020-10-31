package com.example.jsonttu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonttu.adapters.AdapterForQuestions
import com.example.jsonttu.pojo.Question
import com.google.gson.Gson

class SecondActivity : AppCompatActivity() {

    companion object {
        const val listQCV = "listQCV"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val questions: String? = intent.getStringExtra(listQCV)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewQuestion)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterForQuestions(getListOfQuestions(questions))
    }

    private fun getListOfQuestions(jsonStr: String?): List<Question> {
        return Gson()
                .fromJson(jsonStr, Array<Question>::class.java)
                .toList()
    }
}