package com.example.titovtima.mathgame.Exercises

import android.content.Context
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import com.example.titovtima.mathgame.R
import kotlinx.android.synthetic.main.text_and_textanswer.view.*

class TextAnswerExercise (context : Context): Exercise(context) {

    var question = text//: TextView? = null
    var ans = edittext//: EditText? = null
    var button = submit
    var rightans : String = ""

    constructor(context: Context, text1 : String, answer : String) : this(context){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.text_and_textanswer, this)
        this.question = text
        this.ans = edittext
        this.button = submit
        question.text = text1
        rightans = answer
    }
}