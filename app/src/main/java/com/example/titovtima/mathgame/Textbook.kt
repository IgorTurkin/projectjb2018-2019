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
            intent.putExtra(Constants.keytopic,this.intent.getIntExtra(Constants.keytopic,0))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        tasks.setOnClickListener {
            val intent = Intent(this,Tasks::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            intent.putExtra(Constants.keytopic,this.intent.getIntExtra(Constants.keytopic,0))
            startActivity(intent)
        }

        when (this.intent.getStringExtra(Constants.keysubject)){
            "alg" ->{
                caption.text = "Алгебра. " + numToAlgTopic(this.intent.getIntExtra(Constants.keytopic,0)) + "."
                //load text file
            }
            "geom" ->{
                caption.text = "Геометрия. " + numToGeomTopic(this.intent.getIntExtra(Constants.keytopic,0)) + "."
                //load text file
            }
        }
    }
}
