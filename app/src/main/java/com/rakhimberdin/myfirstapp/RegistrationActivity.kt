package com.rakhimberdin.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val byPhoneTv = findViewById<TextView>(R.id.tv_by_phone);
        val byEmailTv = findViewById<TextView>(R.id.tv_by_email);
        val etEmail = findViewById<EditText>(R.id.et_email);
        val btRegister = findViewById<Button>(R.id.bt_register);
        val etPassword = findViewById<EditText>(R.id.et_password);
        val etRepeatPassword = findViewById<EditText>(R.id.et_repeat_password);
        var emailInputFlag = true;
        val defaultColor = byPhoneTv.currentTextColor;

        byPhoneTv.setOnClickListener {
            byPhoneTv.setTextColor(resources.getColor(R.color.purple_200));
            byEmailTv.setTextColor(defaultColor);
            emailInputFlag = false;
            etEmail.hint = "Введите номер";
            etEmail.inputType = InputType.TYPE_CLASS_PHONE;
        }

        byEmailTv.setOnClickListener {
            byEmailTv.setTextColor(resources.getColor(R.color.purple_200));
            byPhoneTv.setTextColor(defaultColor);
            emailInputFlag = true;
            etEmail.hint = "Введите email";
            etEmail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
        }

        btRegister.setOnClickListener {
            val etEmailText = etEmail.text.toString();
            val etPasswordText = etPassword.text.toString();
            val etRepeatPasswordText = etRepeatPassword.text.toString();

            if (emailInputFlag && !etEmailText.contains('@'))
                Toast.makeText(this, "Email должен содержать символ @", Toast.LENGTH_LONG).show();

            if (!emailInputFlag && !etEmailText.contains('+'))
                Toast.makeText(this, "Телефон должен содержать символ +", Toast.LENGTH_LONG).show();

            if (etPasswordText.length < 8)
                Toast.makeText(this, "Пароль должен быть минимум 8 символов", Toast.LENGTH_LONG).show();

            if (etPasswordText != etRepeatPasswordText)
                Toast.makeText(this, "Пароли должны совпадать", Toast.LENGTH_LONG).show();
        }
    }
}