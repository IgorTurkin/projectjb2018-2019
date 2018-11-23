package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_textbook.*

class Textbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textbook)

        Toast.makeText(this,this.intent.getStringExtra(Constants.keysubject), Toast.LENGTH_SHORT).show()

        back.setOnClickListener {
            val intent = Intent(this,InSubject::class.java)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        tasks.setOnClickListener {
            val intent = Intent(this,Tasks::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            startActivity(intent)
        }

        when (this.intent.getStringExtra(Constants.keysubject)){
            "alg1" ->{
                text.text = "алгебра 1"
                caption.text = "Алгебра. Тема 1."
            }
            "alg2" ->{
                text.text = "алгебра 2"
                caption.text = "Алгебра. Тема 2."
            }
            "geom1" ->{
                text.text = "геометрия 1"
                caption.text = "Геометрия. Тема 1."
            }
            "geom2" ->{
                text.text = "геометрия 2"
                caption.text = "Геометрия. Тема 2."
            }
        }
    }
}
