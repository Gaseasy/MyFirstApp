package com.rakhimberdin.myfirstapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var settingsEmail = "default";
    private var settingsPhone = "default";
    private var settingsPassword = "default";
    private lateinit var storage: SharedPreferences;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        val etEmail = findViewById<EditText>(R.id.et_login_email);
        val etPassword = findViewById<EditText>(R.id.et_login_password);
        val cbAutoEnter = findViewById<CheckBox>(R.id.cb_auto_enter);
        val btLogin = findViewById<Button>(R.id.bt_login);

        btLogin.setOnClickListener() {
            val email = etEmail.text.toString();
            val password = etPassword.text.toString();
            val autoEnter = cbAutoEnter.isChecked;

            getSettings();

            if ((email == settingsEmail || email == settingsPhone) && password == settingsPassword) {
                val intent = Intent(this, ContentActivity::class.java)
                storage.edit().putBoolean("autoEnter", autoEnter).apply();
                startActivity(intent);
                return@setOnClickListener;
            }

            Toast.makeText(this, "Данного пользователя не существует", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getSettings() {
        storage = getSharedPreferences("settings", Context.MODE_PRIVATE);

        settingsEmail = storage.getString("email", "default").toString();
        settingsPhone = storage.getString("phone", "default").toString();
        settingsPassword = storage.getString("password", "default").toString();
    }
}