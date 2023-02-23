package com.dragon.apps.caesar_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the encryption button
        val encryption :Button = findViewById(R.id.encr_btn)
        // get the decryption button
        val decryption :Button = findViewById(R.id.decr_btn)
        // get the entered text - text input
        val enteredText : TextInputEditText= findViewById(R.id.entered_text)
        // get the result - text input
        val res : TextInputEditText= findViewById(R.id.res)

        // create an object from cipher class
        val cipher = Cipher()

        // encryption button listener
        encryption.setOnClickListener{
            // get the entered text
            val text =  enteredText.text.toString()
            // get the text after encryption
            val cipherText = cipher.encryption(text, 4)
            // display encryption text
            res.setText(cipherText)
        }

        // decryption button listener
        decryption.setOnClickListener{

        }
    }
}

class Cipher
{
    private val alpha = "abcdefghijklmnopqrstuvwxyz !@#$"
    private var alphaLen = alpha.length

    fun  encryption(plainText: String, k: Int = 4) : String
    {
        var plainLen = plainText.length
        var cipher = ""

        for (item in plainText)
        {
            cipher +=  alpha[ (k + alpha.indexOf(item)) % alphaLen ]
        }
        return cipher
    }
}