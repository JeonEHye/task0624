package com.example.task0624

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idEditText=findViewById<EditText>(R.id.editText1)
        val strId = idEditText.text.toString()

        val pwEditText=findViewById<EditText>(R.id.editText2)
        val strPw = pwEditText.text.toString()

        val submitButton1=findViewById<Button>(R.id.button1)
        submitButton1.setOnClickListener {

            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("ID",strId)

            if(idEditText.text.isEmpty()){
                Toast.makeText(this,"아이디를 확인해주세요.",Toast.LENGTH_SHORT).show()

            }
            else if (pwEditText.text.isEmpty()){
                Toast.makeText(this,"비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()

                val editText1Data = idEditText.text.toString()
                val intent1=Intent(this,HomeActivity::class.java)
                intent1.putExtra("data1FromSignInActivity",editText1Data)
                startActivity(intent1)
            }
        }

        val submitButton2=findViewById<Button>(R.id.button2)
        submitButton2.setOnClickListener {
            val intent2=Intent(this,SignUpActivity::class.java)
            resultLauncher.launch(intent2)
        }

        resultLauncher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == RESULT_OK){
                val id = result.data?.getStringExtra("id")?:""
                val password = result.data?.getStringExtra("password")?:""

                idEditText.setText(id)
                pwEditText.setText(password)
            }
        }

    }
}