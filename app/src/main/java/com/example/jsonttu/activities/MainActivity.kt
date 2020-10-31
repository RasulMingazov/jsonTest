package com.example.jsonttu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonttu.adapters.AdapterForTests
import com.example.jsonttu.pojo.Test
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testsList: List<Test> = getList()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTest)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterForTests(testsList)
    }

    fun getFile(): String { return applicationContext.assets.open("Test.json").bufferedReader().use {it.readText()} }

    private fun getList(): List<Test> {
        return Gson()
               .fromJson(getFile(), Array<Test>::class.java)
                .toList()
    }

    fun startSecondActivity(view: View) {
        val textView = view as TextView
        val text = textView.text.toString()
        val secondActivity = Intent(this, SecondActivity::class.java)
        secondActivity.putExtra("listQCV", getQuestionList(text))
        startActivity(secondActivity)
    }

    fun getQuestionList(text: String): String {
        val testsList: List<Test> = getList()
        var a = ""
        for (test: Test in testsList) {
            if (test.name == text)
                a = Gson().toJson(test.questions)
        }
        return a
    }
}