package com.example.happybirthday

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun rollDice() {
            //Create Dice with 6 sides
            val dice1 = Dice(6)
            val diceRoll1 = dice1.roll()

            //Create a lucky number
            val luckyNum1 = 4

            //Create the TextView in the Layout
            val resultTextView: TextView = findViewById(R.id.textView)

            //Checking case when we have luck num
            when (diceRoll1) {
                luckyNum1 -> resultTextView.text = "Lucky num "+diceRoll1.toString() + "! You are totally lucky!"
                in 1..luckyNum1 - 1, in luckyNum1 + 1..diceRoll1 -> resultTextView.text =
                    "You get " +diceRoll1.toString() + "! Oops...try again!!"
            }

            //Create the ImageView in the Layout
            val diceImage: ImageView = findViewById(R.id.imageView2)

            //Determine which drawable side on the dice roll
            val drawableResult = when (diceRoll1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResult)

        }

        //Clicker
        val rollButton: Button = findViewById(R.id.button4)
        rollButton.setOnClickListener { rollDice() }
    }

    //roll
    class Dice(val numSides1: Int) {
        fun roll(): Int {
            return (1..numSides1).random()
        }
    }
}