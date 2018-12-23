package com.example.titovtima.mathgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_insubject.*

class InSubject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insubject)

//        Toast.makeText(this,this.intent.getStringExtra(Constants.keysubject),Toast.LENGTH_SHORT).show()

//        tasks.setOnClickListener {
//            val intent = Intent(this,Tasks::class.java)
//            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
//            intent.putExtra(Constants.keytopic,this.intent.getIntExtra(Constants.keytopic,0))
//            startActivity(intent)
//        }

        textbook.setOnClickListener {
            val intent = Intent(this,Textbook::class.java)
            intent.putExtra(Constants.keysubject,this.intent.getStringExtra(Constants.keysubject))
            intent.putExtra(Constants.keytopic,this.intent.getIntExtra(Constants.keytopic,0))
            startActivity(intent)
        }

        val topic = this.intent.getIntExtra(Constants.keytopic,0)
        when (this.intent.getStringExtra(Constants.keysubject)){
            "alg" ->{
                caption.text = "Алгебра. " + numToAlgTopic(topic) + "."

                val ll = Array((Constants.kolAlgTasks[topic] + 4)/5, {LinearLayout(this)})
                var rlparams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
                rlparams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.texttasks)
                ll[0].layoutParams = rlparams
                ll[0].orientation = LinearLayout.HORIZONTAL
                ll[0].weightSum = 5f
                llayoutchoosetasks.addView(ll[0])
                for (i in 1..(Constants.kolAlgTasks[topic] + 4)/5 - 1){
                    rlparams.addRule(RelativeLayout.ALIGN_BOTTOM, ll[i-1].id)
                    ll[i].layoutParams = rlparams
                    ll[i].orientation = LinearLayout.HORIZONTAL
                    ll[i].weightSum = 5f
                    llayoutchoosetasks.addView(ll[i])
                }

                val llparams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                llparams.setMargins(10, 0, 10, 0)
                llparams.weight = 1f
                for (i in 1..Constants.kolAlgTasks[topic]){
                    var button = Button(this)
                    button.text = i.toString()
                    button.layoutParams = llparams
                    ll[(i-1)/5].addView(button)
                    button.setOnClickListener {
                        val intent = Intent(this, Tasks::class.java)
                        intent.putExtra(Constants.keysubject, this.intent.getStringExtra(Constants.keysubject))
                        intent.putExtra(Constants.keytopic, topic)
                        intent.putExtra(Constants.keytask, i-1)
                        startActivity(intent)
                    }
                }
//                for (i in Constants.kolAlgTasks[topic] % 5 downTo 1){
//                    val text0 = TextView(this)
//                    text0.layoutParams = llparams
//                    ll[ll.size-1].addView(text0)
//                }
            }
            "geom" -> caption.text = "Геометрия. " + numToGeomTopic(this.intent.getIntExtra(Constants.keytopic,0)) + "."
        }
    }
}
