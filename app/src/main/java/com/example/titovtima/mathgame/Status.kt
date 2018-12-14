package com.example.titovtima.mathgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.titovtima.mathgame.Exercises.ButtonExercise
import kotlinx.android.synthetic.main.activity_status.*

class Status : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        val xp = TextView(this)
        xp.text = StatusCode.xp.toString()
        rlayoutstatus.addView(xp)

        incxp.setOnClickListener {
            var button = Button(this)
            button.text = "text1"
            var rlparams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            rlparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            rlparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
//            button.layoutParams = rlparams
            var exercise = ButtonExercise(this, button)
            exercise.button!!.text = "12345"
//            exercise.layoutParams = rlparams
            rlayoutstatus.addView(exercise)
            exercise.layoutParams = rlparams
        }


    }
}
