package com.thicc.cabom.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.core.graphics.ColorUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pop_up.*
import kotlinx.android.synthetic.main.activity_pop_up.Rounded_Profile_Picture_c
import kotlinx.android.synthetic.main.activity_pop_up.Speaker_Name_c
import kotlinx.android.synthetic.main.activity_questions.*

class PopUp : AppCompatActivity()
{
    private var Speaker_Icon = ""
    private var Speaker_Name = ""
    private var Choose = ""
    private var Guess_Answer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        Speaker_Icon = bundle?.getString("S_Icon", "Icon") ?: ""
        Speaker_Name = bundle?.getString("S_Name", "Name") ?: ""
        Choose = bundle?.getString("Choose_Title", "Choose With Me") ?: ""
        Guess_Answer = bundle?.getString("S_Answer", "I think the answer is 1") ?: ""

        // Set the data
        Picasso.with(this).load("${Speaker_Icon}").into(Rounded_Profile_Picture_c)
        Speaker_Name_c.text = Speaker_Name
        Choose_c.text = Choose
        Guess_Answer_c.text = Guess_Answer

        // Fade animation for the background of Popup Window
        val alpha = 100 //between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), Color.TRANSPARENT, alphaColor)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            Full_Window.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        // Fade animation for the Popup Window
        Full_Window.alpha = 0f
        Full_Window.animate().alpha(1f).setDuration(500).setInterpolator(
            DecelerateInterpolator()
        ).start()

        // Close the Popup Window when you press the button
        Close_c.setOnClickListener {
            onBackPressed()
        }

        Agree_c.setOnClickListener {
            onBackPressed()
        }


        this.window.statusBarColor = Color.TRANSPARENT
        setWindowFlag(this, false)

    }

    private fun setWindowFlag(activity: Activity, on: Boolean) {
        val win = activity.window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        } else {
            winParams.flags = winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
        }
        win.attributes = winParams
    }

    override fun onBackPressed() {
        // Fade animation for the background of Popup Window when you press the back button
        val alpha = 100 // between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), alphaColor, Color.TRANSPARENT)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            Full_Window.setBackgroundColor(
                animator.animatedValue as Int
            )
        }

        // Fade animation for the Popup Window when you press the back button
        Full_Window.animate().alpha(0f).setDuration(500).setInterpolator(
            DecelerateInterpolator()
        ).start()

        // After animation finish, close the Activity
        colorAnimation.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                finish()
                overridePendingTransition(0, 0)
            }
        })
        colorAnimation.start()
    }

}