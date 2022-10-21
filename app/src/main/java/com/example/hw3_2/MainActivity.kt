package com.example.hw3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv_riddle = findViewById<TextView>(R.id.textView3)
        val btn_riddle = findViewById<Button>(R.id.button)
        val btn_answer = findViewById<Button>(R.id.button3)
        val btn_ReAnswer = findViewById<Button>(R.id.button4)
        val btn_showAnswer = findViewById<Button>(R.id.button2)
        val app_title = findViewById<TextView>(R.id.textView2)
        val tv2 = findViewById<TextView>(R.id.textView4)
        val hint = findViewById<EditText>(R.id.editTextTextPersonName)
        val tv_result = findViewById<TextView>(R.id.textView)


        var index = 0
        val riddleList = mutableListOf("0000，猜一句成語。:四大皆空","人有他大，天沒他大。:白","台灣女孩，猜一個字。:始","九十九，猜一個字。:白","0+0=1，猜一成語:無中生有。")
        hint.text = null
        tv_result.text = null


        btn_riddle.setOnClickListener{
            hint.text = null
            tv_result.text = null
            index = (Math.random()*4).toInt()+1
            val countRiddle = riddleList.count()
            val (riddle,answer) = riddleList[0].split(":")
            tv_riddle.text = "謎題："+riddle
            if(index>=countRiddle)
                index=0
            btn_answer.setOnClickListener {
                val ans = hint.text
                if (ans.toString() == answer){
                    tv_result.text = " bingo"
//                    Toast.makeText(this,hint.text, Toast.LENGTH_SHORT).show()
                }
                else{
                    tv_result.text = "not correct"
                }
                btn_ReAnswer.setOnClickListener {
                    hint.text = null
                    tv_result.text = null
                }
                btn_showAnswer.setOnClickListener {
                    tv_result.text = "謎底是"+ answer
                }
            }

        }

    }
}