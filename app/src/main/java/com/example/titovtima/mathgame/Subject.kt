package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_subject.*

class Subject : AppCompatActivity() {

    val key = "subject"

    fun onClick(view : View){
        val intent = Intent(this,InSubject::class.java)
        val id = view.id
//        Toast.makeText(this,id,Toast.LENGTH_LONG).show()
        if ((id >= alg1.id)&&(id <= alg2.id)) {
            intent.putExtra(Constants.keysubject, "alg")
            intent.putExtra(Constants.keytopic,id - alg1.id)
        }
        if ((id >= geom1.id)&&(id <= geom2.id)) {
            intent.putExtra(Constants.keysubject, "geom")
            intent.putExtra(Constants.keytopic, id - geom1.id)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

//        alg1.setOnClickListener {
//            val intent = Intent(this, InSubject::class.java)
//            intent.putExtra(key,"alg1")
//            startActivity(intent)
//        }
//
//        alg2.setOnClickListener {
//            val intent = Intent(this,InSubject::class.java)
//            intent.putExtra(key,"alg2")
//            startActivity(intent)
//        }
//
//        geom1.setOnClickListener {
//            val intent = Intent(this,InSubject::class.java)
//            intent.putExtra(key,"geom1")
//            startActivity(intent)
//        }
//
//        geom2.setOnClickListener {
//            val intent = Intent(this,InSubject::class.java)
//            intent.putExtra(key,"geom2")
//            startActivity(intent)
//        }
        alg1.setOnClickListener (::onClick)
        alg2.setOnClickListener (::onClick)
        geom1.setOnClickListener (::onClick)
        geom2.setOnClickListener (::onClick)
    }
}
