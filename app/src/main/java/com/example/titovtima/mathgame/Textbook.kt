package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_textbook.*

class Textbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textbook)

        back.setOnClickListener {
            val intent : Intent
            if (this.intent.getStringExtra("from") == "tasks")
                intent = Intent(this,Tasks::class.java)
            else
                intent = Intent(this,InSubject::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        tasks.setOnClickListener {
            val intent = Intent(this,Tasks::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("subject",this.intent.getStringExtra("subject"))
            startActivity(intent)
        }
    }
}
