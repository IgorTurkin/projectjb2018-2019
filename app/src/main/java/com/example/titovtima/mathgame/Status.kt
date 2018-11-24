package com.example.titovtima.mathgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_status.*

class Status : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        val xp = TextView(this)
        xp.text = StatusCode.xp.toString()
        rlayoutstatus.addView(xp)

        incxp.setOnClickListener {
            StatusCode.xp++
            xp.text = StatusCode.xp.toString()
        }
    }
}
