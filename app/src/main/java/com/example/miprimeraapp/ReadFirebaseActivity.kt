package com.example.miprimeraapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference

class ReadFirebaseActivity: AppCompatActivity() {

    // FIREBASE
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readfirebase)
    }
}