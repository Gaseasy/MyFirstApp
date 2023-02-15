package com.rakhimberdin.myfirstapp

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.ProgressBar
import java.util.*

class SplashActivity : AppCompatActivity() {

    private var email = "default";
    private var phone = "default";
    private var password = "default";
    private var autoEnter = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progressBar = findViewById<ProgressBar>(R.id.indeterminateBar);

        getSettings();

        var intent = Intent(this, RegistrationActivity::class.java);

        if ((email != "default" || phone != "default") && password != "default")
            intent = if (!autoEnter)
                Intent(this, LoginActivity::class.java)
            else
                Intent(this, ContentActivity::class.java)

        startActivity(intent);
    }

    private fun getSettings() {
        val storage = getSharedPreferences("settings", Context.MODE_PRIVATE);

        email = storage.getString("email", "default").toString();
        phone = storage.getString("phone", "default").toString();
        password = storage.getString("password", "default").toString();
        autoEnter = storage.getBoolean("autoEnter", false);
    }
}