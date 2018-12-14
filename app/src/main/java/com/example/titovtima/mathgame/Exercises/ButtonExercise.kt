package com.example.titovtima.mathgame.Exercises

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import com.example.titovtima.mathgame.R
import kotlinx.android.synthetic.main.only_button.view.*

class ButtonExercise (context: Context) : Exercise (context) {

    var button : Button? = null

    constructor(context : Context, button : Button): this(context){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.only_button, this)
        this.button = butex
        this.button!!.text = button.text
    }
}