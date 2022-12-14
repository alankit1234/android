package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        submitButton.setOnClickListener {
            val enteredName = inputField.text.toString()
            if (enteredName == "") {
                offersButton.visibility= INVISIBLE
                greetingTextView.text = ""
                Snackbar.make(
                    findViewById(R.id.test),
                    "Please,enter your name",
                    Snackbar.LENGTH_SHORT).show()
            }else {
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility= VISIBLE
            }
        }
        offersButton.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java )
            startActivity(intent)
        }
    }
}