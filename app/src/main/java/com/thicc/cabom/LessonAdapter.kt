package com.thicc.cabom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thicc.cabom.models.LessonCard
import kotlinx.android.synthetic.main.lesson_item.view.*

class LessonAdapter(private val context: Context,private val lessonCards:ArrayList <LessonCard>):
    RecyclerView.Adapter<LessonAdapter.LessonCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonAdapter.LessonCardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val lessonCardView = layoutInflater.inflate(R.layout.lesson_item, parent, false)

        return LessonCardViewHolder(lessonCardView)
    }

    override fun getItemCount(): Int {
        return lessonCards.size
    }

    override fun onBindViewHolder(holder: LessonAdapter.LessonCardViewHolder, position: Int) {
        val lesson:LessonCard=lessonCards[position]
        holder.lessonTitle.text=lesson.title
        holder.lessonNumber.text="Lesson " +lesson.lessonNumber.toString()
        holder.lessonDescription.text=lesson.description
    }

    inner class LessonCardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val lessonTitle: TextView=itemView.lessonTitle
        val lessonNumber: TextView=itemView.lessonNumber
        val lessonDescription:TextView=itemView.lessonDescription
    }
}