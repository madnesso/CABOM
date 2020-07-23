package com.thicc.cabom.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.core.graphics.ColorUtils
import com.bumptech.glide.load.resource.transcode.UnitTranscoder.get
import com.squareup.picasso.Picasso
import com.thicc.cabom.R
import kotlinx.android.synthetic.main.activity_pop_up.*
import kotlinx.android.synthetic.main.activity_pop_up.Rounded_Profile_Picture_c
import kotlinx.android.synthetic.main.activity_pop_up.Speaker_Name_c
import kotlinx.android.synthetic.main.activity_questions.*

class PopUp : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up)

        // Set the data
        //Picasso.get().load("intent.getStringExtra("S_Icon")).into(Rounded_Profile_Picture_c)
//        Speaker_Name_c?.text = intent.getStringExtra("S_Name")
//        Choose_c?.text = intent.getStringExtra("Choose_Title")
//        Guess_Answer_c?.text = intent.getStringExtra("S_Answer")

        var dm  = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        var width = dm?.widthPixels
        var height = dm?.heightPixels
        if (width != null && height != null)
        {
            window.setLayout((width*0.9).toInt(), (height*0.8).toInt())
        }

        var params : WindowManager.LayoutParams = window.attributes
        params.gravity = Gravity.CENTER
        params.x = 0
        params.y = 0
        window.attributes = params


    }

}