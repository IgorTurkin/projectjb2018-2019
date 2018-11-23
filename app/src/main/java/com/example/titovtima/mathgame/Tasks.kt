package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tasks.*

class Tasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        Toast.makeText(this,this.intent.getStringExtra(Constants.keysubject), Toast.LENGTH_SHORT).show()

        back.setOnClickListener {
            val intent = Intent(this,InSubject::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            startActivity(intent)
        }

        textbook.setOnClickListener {
            val intent = Intent(this,Textbook::class.java)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        when (this.intent.getStringExtra(Constants.keysubject)){
            "alg1" ->{
                val text1 = TextView(this)
                text1.text = "алгебра, тема 1"
                llayouttasks.addView(text1)
                caption.text = "Алгебра. Тема 1."
            }
            "alg2" ->{
                val text1 = TextView(this)
                text1.text = "алгебра, тема 2"
                llayouttasks.addView(text1)
                caption.text = "Алгебра. Тема 2."
            }
            "geom1" ->{
                val text1 = TextView(this)
                text1.text = "геометрия, тема 1"
                llayouttasks.addView(text1)
                caption.text = "Геометрия. Тема 1."
            }
            "geom2" ->{
                val text1 = TextView(this)
                text1.text = "геометрия, тема 2"
                llayouttasks.addView(text1)
                caption.text = "Геометрия. Тема 2."
            }
        }
    }
}
