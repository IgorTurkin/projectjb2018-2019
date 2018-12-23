package com.example.titovtima.mathgame

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.titovtima.mathgame.Exercises.ButtonExercise
import com.example.titovtima.mathgame.Exercises.Exercise
import com.example.titovtima.mathgame.Exercises.TextAnswerExercise
import kotlinx.android.synthetic.main.activity_tasks.*

class Tasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

//        Toast.makeText(this,this.intent.getStringExtra(Constants.keysubject), Toast.LENGTH_SHORT).show()

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

        val subject = this.intent.getStringExtra(Constants.keysubject)
        val topic = this.intent.getIntExtra(Constants.keytopic,0)
        val task = this.intent.getIntExtra(Constants.keytask, 0)

        when (subject){
            "alg" ->{
                caption.text = "Алгебра. " + numToAlgTopic(this.intent.getIntExtra(Constants.keytopic,0)) + "."
                when (topic){
                    0 ->{
                        when (task){
                            0 -> {
                                var exercise = TextAnswerExercise(this, "Capital of Russia", "Saint Petersburg")
//                                exercise.question.text = "Capital of Russia"
                                exercise.ans.hint = "Saint Petersburg"
//                            layout.addView(exercise)
                                exercise.button.setOnClickListener {
                                    if (exercise.ans.text.toString() == exercise.rightans){
                                        StatusCode.completeAlg[0][0] = true
                                        Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show()
                                        if (task < Constants.kolAlgTasks[topic] - 1) {
                                            val intent = Intent(this, Tasks::class.java)
                                            intent.putExtra(Constants.keysubject, subject)
                                            intent.putExtra(Constants.keytopic, topic)
                                            intent.putExtra(Constants.keytask, task + 1)
                                            startActivity(intent)
                                        }
                                    }else{
                                        exercise.ans.text.clear()
                                        Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                llayouttasks.addView(exercise)
                            }
                            1 -> {
                                var exercise = TextAnswerExercise(this, "2+2", "4")
//                                exercise.question.text = "Capital of Russia"
                                exercise.ans.hint = "5"
//                            layout.addView(exercise)
                                exercise.button.setOnClickListener {
                                    if (exercise.ans.text.toString() == exercise.rightans){
                                        StatusCode.completeAlg[0][1] = true
                                        Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show()
                                        if (task < Constants.kolAlgTasks[topic] - 1) {
                                            val intent = Intent(this, Tasks::class.java)
                                            intent.putExtra(Constants.keysubject, subject)
                                            intent.putExtra(Constants.keytopic, topic)
                                            intent.putExtra(Constants.keytask, task + 1)
                                            startActivity(intent)
                                        }
                                    }else{
                                        exercise.ans.text.clear()
                                        Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                llayouttasks.addView(exercise)
                            }
                        }
//                        llayouttasks.addView(loadTask(this, "alg", 1, 1))//StatusCode.completeAlg[1]))
                    }
                    1 ->{
                        llayouttasks.addView(loadTask(this, "alg", 2, 1))//StatusCode.completeAlg[1]))
                    }
                }
            }
            "geom" ->{
                caption.text = "Геометрия. " + numToGeomTopic(this.intent.getIntExtra(Constants.keytopic,0)) + "."
                when (this.intent.getIntExtra(Constants.keytopic,0)){
                    0 ->{

                    }
                    1 ->{

                    }
                }
            }
        }
    }
}


fun loadTask (context: Context, subject: String, topic: Int, task: Int) : Exercise? {
    var exercise : Exercise? = null
    when (subject){
        "alg" -> {
            when (topic){
                1 ->{
                    when (task){
                        1 ->{
                            exercise = TextAnswerExercise(context, "", "")
                            exercise.question.text = "Capital of Russia"
                            exercise.ans.hint = "Saint Petersburg"
//                            layout.addView(exercise)
                            exercise.button.setOnClickListener {
                                if ((exercise as TextAnswerExercise).ans.text.toString() == (exercise as TextAnswerExercise).rightans){
                                    (exercise as TextAnswerExercise).completed = true

                                }else{
                                    (exercise as TextAnswerExercise).ans.text.clear()
                                    Toast.makeText(context, "Неправильно!", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                        2 ->{

                        }
                    }
                }
                2 ->{
                    when (task){
                        1 ->{
                            exercise = TextAnswerExercise(context, "", "")
                            exercise.question.text = "Capital of USA"
                            exercise.ans.hint = "Moscow"
//                            layout.addView(exercise)
                        }
                    }
                }
            }
        }
//        else -> exercise
    }
    return exercise
}