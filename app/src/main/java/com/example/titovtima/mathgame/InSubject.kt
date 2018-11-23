package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_insubject.*

class InSubject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insubject)

        tasks.setOnClickListener {
            val intent = Intent(this,Tasks::class.java)
            startActivity(intent)
        }

        textbook.setOnClickListener {
            val intent = Intent(this,Textbook::class.java)
            intent.putExtra("from","insubject")
            startActivity(intent)
        }
    }
}
