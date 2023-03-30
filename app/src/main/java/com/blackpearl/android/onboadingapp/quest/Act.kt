package com.blackpearl.android.onboadingapp.quest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setPadding
import com.blackpearl.android.onboadingapp.R


class Act(
    private val context: Context,
    private val index: Int,
    private val nextActCallback: (Int) -> Unit,
) {

    // translate 123.dp (123 in dp) to pixels
    private val Int.dp: Int
        get() = (context.resources.displayMetrics.density * this + 0.5f).toInt()


    private val views = mutableListOf<View>()

    private lateinit var motionLayout: MotionLayout

    fun addNarrator(speech: String, buttonText: String) {

        val inflater = LayoutInflater.from(context)

        motionLayout = inflater.inflate(R.layout.quest_narrator, null) as MotionLayout

        motionLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        val textView = motionLayout.findViewById<TextView>(R.id.text)
        val button = motionLayout.findViewById<Button>(R.id.button)

        textView.text = speech
        button.text = buttonText
        button.setOnClickListener { nextActCallback(index + 1) }

    }

    fun addNarrator(txt: String): Act {

        val textView = TextView(context).apply {
            text = txt

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            setPadding(100.dp)

        }

        views += textView

        return this
    }

    fun addNextButton(txt: String): Act {

        val button = Button(context).apply {
            text = txt

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            setOnClickListener {
                nextActCallback(index+1)
            }
        }

        views += button

        return this
    }

    fun addNarrator(textStringRes: Int): Act {
        return this
    }

    fun getViews(): List<View> = views
    fun getMotionLayout() = motionLayout
}