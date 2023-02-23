package com.dragon.apps.caesar_app

import CipherClass
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the encryption button
        val encryption :Button = findViewById(R.id.encr_btn)
        // get the decryption button
        val decryption :Button = findViewById(R.id.decr_btn)
        // get the entered text - text input
        val kValue: TextInputEditText= findViewById(R.id.k_value)
        // get the entered text - text input
        val enteredText : TextInputEditText= findViewById(R.id.entered_text)
        // get the result - text input
        val res : TextInputEditText= findViewById(R.id.res)

        // create an object from cipher class
        val cipher = CipherClass()

        // encryption button listener
        encryption.setOnClickListener{
            // get the entered text
            val text =  enteredText.text.toString()
            // get the entered k
            val k =  kValue.text.toString()

            if (k != "" && text != "")
            {
                // display encryption text
                res.setText(cipher.encryption(text, k.toInt()))
            }
            else
            {
                // Error Message
                res.setText("'Error:' Enter the text value and K value")
            }
        }

        // decryption button listener
        decryption.setOnClickListener{
            // get the entered text
            val text =  enteredText.text.toString()
            // get the entered k
            val k =  kValue.text.toString()

            if (k != "" && text != "")
            {
                // display encryption text
                res.setText(cipher.decryption(text, k.toInt()))
            }
            else
            {
                // Error Message
                res.setText("'Error:' Enter the text value and K value")
            }
        }

        enteredText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                res.setText("")
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}

