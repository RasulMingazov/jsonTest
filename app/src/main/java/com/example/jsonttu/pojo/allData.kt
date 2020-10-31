package com.example.jsonttu.pojo

data class Test(val testId: Int, val name: String, val questions: List<Question>)

data class Question(val questionId: Int, val text: String, val answers: List<Answer>)

data class Answer(val answerId: Int, val text: String)