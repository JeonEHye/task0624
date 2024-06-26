package com.example.task0624

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task0624.R.id.siName
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val randomImg = findViewById<ImageView>(R.id.imageView1)
        when(Random.nextInt(1, 6)) {
            1 -> randomImg.setImageResource(R.drawable.aaa)
            2 -> randomImg.setImageResource(R.drawable.bbb)
            3 -> randomImg.setImageResource(R.drawable.ccc)
            4 -> randomImg.setImageResource(R.drawable.ddd)
            5 -> randomImg.setImageResource(R.drawable.eee)
        }

        val editText1Data = intent.getStringExtra("data1FromSignInActivity")
        val siId = findViewById<EditText>(R.id.siId)
        siId.setText(editText1Data)

        val editText2Data = intent.getStringExtra("data2FromSignInActivity")
        val siName = findViewById<EditText>(R.id.siName)
        siName.setText(editText2Data)

        val submitButton4=findViewById<Button>(R.id.button4)
        submitButton4.setOnClickListener {
            finish()
        }
    }
}