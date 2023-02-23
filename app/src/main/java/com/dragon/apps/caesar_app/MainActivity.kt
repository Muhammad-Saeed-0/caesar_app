package com.dragon.apps.caesar_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val encr :Button = findViewById(R.id.encr_btn)
        val decr :Button = findViewById(R.id.decr_btn)

        encr.setOnClickListener{
            val ciper = Cipher()
            ciper.encryption("he!l o#", 4)
        }

        decr.setOnClickListener{

        }
    }
}

class Cipher
{
    private val alpha = "abcdefghijklmnopqrstuvwxyz !@#$"
    private var alphaLen = alpha.length
    fun  encryption(plainText: String, k: Int = 4)
    {
        val TAG = "encryption"

        var plainLen = plainText.length
        var cipher = ""
        for (item in plainText)
        {
            cipher +=  alpha[ (k + alpha.indexOf(item)) % alphaLen ]
        }

        Log.d(TAG, "encryption: " + cipher)
    }

}