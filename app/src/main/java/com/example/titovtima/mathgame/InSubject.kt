package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insubject.*

class InSubject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insubject)

        Toast.makeText(this,this.intent.getStringExtra(Constants.keysubject),Toast.LENGTH_SHORT).show()

        tasks.setOnClickListener {
            val intent = Intent(this,Tasks::class.java)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            startActivity(intent)
        }

        textbook.setOnClickListener {
            val intent = Intent(this,Textbook::class.java)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            startActivity(intent)
        }

        when (this.intent.getStringExtra(Constants.keysubject)){
            "alg1" -> caption.text = "Алгебра. Тема 1."
            "alg2" -> caption.text = "Алгебра. Тема 2."
            "geom1" -> caption.text = "Геометрия. Тема 1."
            "geom2" -> caption.text = "Геометрия. Тема 2."
        }
    }
}
