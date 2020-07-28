package com.thicc.cabom.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.library.NavigationBar
import com.library.NvTab
import com.thicc.cabom.R
import kotlinx.android.synthetic.main.activity_journey.*


class Journey : AppCompatActivity(), NavigationBar.OnTabSelected, NavigationBar.OnTabClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey)
        val bar = navBar as NavigationBar
        bar.onTabSelected = this
        bar.onTabClick = this
        bar.tabCount = 5
        bar.animateView(3000)
        val pos = 1
        bar.currentPosition = pos

    }

    override fun onTabSelected(touchPosition: Int, prev: NvTab?, nvTab: NvTab?) {
        TODO("Not yet implemented")
    }

    override fun onTabClick(touchPosition: Int, prev: NvTab?, nvTab: NvTab?) {
        TODO("Not yet implemented")
    }
}