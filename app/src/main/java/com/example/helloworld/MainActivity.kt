package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() { // like int main(), AppCompatActivity inherits from Activity, provides backwards compatibility
    lateinit var diceImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //R class contains all XML resources
        diceImage = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button) // create button, get details from xml via R lib
        rollButton.setOnClickListener {rollDice()} // call roll dice function when button pressed

        // set up the dice reset button
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resetDice() }
    }
    

    private fun rollDice() {
        val drawableResource = when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
            }
        diceImage.setImageResource(drawableResource)
        }

    private fun resetDice() {
        diceImage.setImageResource(R.drawable.empty_dice)
    }
    }