package com.thicc.cabom.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thicc.cabom.R
import kotlinx.android.synthetic.main.activity_questions.*

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        Rounded_Profile_Picture_c.setOnClickListener {
            val intent = Intent(this, PopUp::class.java)
            intent.putExtra("S_Icon", "https://www.w3schools.com/images/picture.jpg")
            intent.putExtra("S_Name", "Ray")
            intent.putExtra("Choose_Title", "Choose with me")
            intent.putExtra("S_Answer", "I think Answer1 is the right choice,\nWhat do you think?")
            startActivity(intent)
        }

    }
}