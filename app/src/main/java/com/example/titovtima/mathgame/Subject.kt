package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_subject.*

class Subject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

        val key = "subject"

        alg1.setOnClickListener {
            val intent = Intent(this, InSubject::class.java)
            intent.putExtra(key,"alg1")
            startActivity(intent)
        }

        alg2.setOnClickListener {
            val intent = Intent(this,InSubject::class.java)
            intent.putExtra(key,"alg2")
            startActivity(intent)
        }
    }
}
