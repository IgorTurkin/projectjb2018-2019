package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next.setOnClickListener {
            val intent = Intent(this,Menu::class.java)
            startActivity(intent)
        }

        for (i : Int in 0..Constants.kolAlgTopics-1)
            StatusCode.completeAlg[i] = 0

        for (i : Int in 0..Constants.kolGeomTopics-1)
            StatusCode.completeGeom[i] = 0

        // Example of a call to a native method
//        sample_text.text = stringFromJNI()

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    external fun stringFromJNI(): String
//
//    companion object {
//
//        // Used to load the 'native-lib' library on application startup.
//        init {
//            System.loadLibrary("native-lib")
//        }
//    }
}
