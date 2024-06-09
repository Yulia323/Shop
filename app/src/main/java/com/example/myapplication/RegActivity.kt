package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || email == "" || pass == "" )
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val user = User (login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login зарегистрирован", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}