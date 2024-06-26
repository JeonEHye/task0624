package com.example.task0624

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val submitButton3=findViewById<Button>(R.id.button3)
        submitButton3.setOnClickListener {

            val nameEditText=findViewById<EditText>(R.id.editText3)
            val strName = nameEditText.text.toString()

            val suidEditText=findViewById<EditText>(R.id.editText4)
            val strId = suidEditText.text.toString()

            val supwEditText=findViewById<EditText>(R.id.editText5)
            val strPw = supwEditText.text.toString()

            val isName = strName.isEmpty()
            val isSuid = strId.isEmpty()
            val isSupw = strPw.isEmpty()


            if(isName||isSuid||isSupw){
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                intent.putExtra("id",strId)
                intent.putExtra("password",strPw)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}