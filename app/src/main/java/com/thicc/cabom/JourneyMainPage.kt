package com.thicc.cabom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thicc.cabom.models.LessonCard
import kotlinx.android.synthetic.main.activity_journey_main_page.*

class JourneyMainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_main_page)

        val lessonsList=getLessons()
        val lessonAdapter=LessonAdapter(this,lessonsList)
        main_recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        main_recycler.adapter=lessonAdapter
    }

    //fake lesson data list
    private fun getLessons(): ArrayList<LessonCard>
    {
        val lessonList:ArrayList<LessonCard> = ArrayList()
        lessonList.add(LessonCard("Struggle",1,"Halo brazers today we will lern how to struggle"))
        lessonList.add(LessonCard("Pain",2,"Halo brazers, today we will learn how to feel the pain"))
        lessonList.add(LessonCard("Suffer",3,"Halo again brazers, today we will learn how to suffer properly"))
        lessonList.add(LessonCard("Final",4,"Hell guys, I learned English properly. Screw you all"))
        return  lessonList
    }
}