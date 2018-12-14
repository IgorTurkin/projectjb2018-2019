package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.titovtima.mathgame.Exercises.ButtonExercise
import com.example.titovtima.mathgame.Exercises.TextAnswerExercise
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
            intent.putExtra(Constants.keytopic,this.intent.getIntExtra(Constants.keytopic,0))
            startActivity(intent)
        }

        textbook.setOnClickListener {
            val intent = Intent(this,Textbook::class.java)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            intent.putExtra(Constants.keytopic,this.intent.getIntExtra(Constants.keytopic,0))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        when (this.intent.getStringExtra(Constants.keysubject)){
            "alg" ->{
                caption.text = "Алгебра. " + numToAlgTopic(this.intent.getIntExtra(Constants.keytopic,0)) + "."
                when (this.intent.getIntExtra(Constants.keytopic,0)){
                    1 ->{
//                        val text1 = TextView(this)
//                        text1.text = "Сколько будет 717÷3?"
//                        text1.textSize = 30f
//                        llayouttasks.addView(text1)
//                        val llayoutans1 = LinearLayout(this)
//                        llayoutans1.orientation = LinearLayout.HORIZONTAL
//                        val ans1_1 = Button(this)
//                        ans1_1.text = "478"
//                        ans1_1.setOnClickListener {  }

//                        val ex1 = ButtonExercise()
//                        val button = Button(this)
//                        button.text = "new text"
//                        ex1.button = button
//                        llayouttasks.addView(ex1)
                    }
                    2 ->{
                        var exercise = TextAnswerExercise(this, "")
                        exercise.question.text = "Capital of Russia"
                        exercise.ans.hint = "Saint Petersburg"
                        llayouttasks.addView(exercise)
                    }
                }
            }
            "geom" ->{
                caption.text = "Геометрия. " + numToGeomTopic(this.intent.getIntExtra(Constants.keytopic,0)) + "."
                when (this.intent.getIntExtra(Constants.keytopic,0)){
                    1 ->{

                    }
                    2 ->{

                    }
                }
            }
        }
    }
}
