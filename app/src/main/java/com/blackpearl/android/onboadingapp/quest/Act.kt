package com.blackpearl.android.onboadingapp.quest

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import coil.load
import com.blackpearl.android.onboadingapp.R

// Button in every MotionLayout that is meant to move to the next Act must have id quest_next_button

class Act(
    private val context: Context,
    private val index: Int,
    private val nextActCallback: (Int) -> Unit,
) {

    // translate 123.dp (123 in dp) to pixels
    private val Int.dp: Int
        get() = (context.resources.displayMetrics.density * this + 0.5f).toInt()

    private var motionLayout: MotionLayout? = null
    private var testId: Int? = null

    fun getMotionLayout() = checkNotNull(motionLayout) { "MotionLayout in Act isn't initialized" }
    fun getTestId() = testId

    fun useNarratorScene(speech: String, buttonText: String, narratorImageId: Int? = null) {

        val inflater = LayoutInflater.from(context)

        motionLayout = (inflater.inflate(R.layout.quest_narrator, null) as MotionLayout)
            .also { layout ->

                layout.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                val textView = layout.findViewById<TextView>(R.id.text)
                val button = layout.findViewById<Button>(R.id.quest_next_button)
                val image = layout.findViewById<ImageView>(R.id.narrator)

                textView.text = speech
                button.text = buttonText
                button.setOnClickListener { nextActCallback(index + 1) }

                narratorImageId?.also {
                    image.load(it)
                }
            }

    }

    fun useTextScene(mainText: String, buttonText: String) {
        val inflater = LayoutInflater.from(context)

        motionLayout = (inflater.inflate(R.layout.quest_text, null) as MotionLayout)
            .also { layout ->

                layout.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                val textView = layout.findViewById<TextView>(R.id.quest_main_text)
                val button = layout.findViewById<Button>(R.id.quest_next_button)

                textView.text = mainText
                button.text = buttonText
                button.setOnClickListener { nextActCallback(index + 1) }
            }


    }

    fun useImageTextScene(text1: String, text2: String, imageId: Int, buttonText: String) {
        val inflater = LayoutInflater.from(context)

        motionLayout = (inflater.inflate(R.layout.qeust_image_text, null) as MotionLayout)
            .also { layout ->

                layout.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                val text_1 = layout.findViewById<TextView>(R.id.text_1)
                val text_2 = layout.findViewById<TextView>(R.id.text_2)
                val button = layout.findViewById<Button>(R.id.quest_next_button)
                val image = layout.findViewById<ImageView>(R.id.image)


                text_1.text = text1
                text_2.text = text2
                button.text = buttonText
                image.load(imageId)

                button.setOnClickListener { nextActCallback(index + 1) }
            }
    }

    fun addTest(id: Int) {
        testId = id
    }
}