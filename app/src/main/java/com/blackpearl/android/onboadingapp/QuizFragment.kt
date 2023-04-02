package com.blackpearl.android.onboadingapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Animatable2.AnimationCallback
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorStateListDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.blackpearl.android.onboadingapp.databinding.FragmentQuizBinding
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class QuizFragment: Fragment() {


    private var _binding: FragmentQuizBinding? = null
    private val binding
            get() = checkNotNull(_binding) {"Fragment quiz binding is null."}

    private val args: QuizFragmentArgs by navArgs()

    private val quizViewModel : QuizViewModel by viewModels() {
        QuizViewModelFactory(args.testId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateQuestion()
    }

    private fun updateQuestion() {

        if (quizViewModel.currentIndex == quizViewModel.test.size) {
            //Test has finished
            setFragmentResult(
                QuizFragment.REQUEST_KEY_POINTS,
                bundleOf(QuizFragment.BUNDLE_KEY_POINTS to quizViewModel.points))
            val arguments = quizViewModel.getArgs()
            findNavController().navigate(
                QuizFragmentDirections.actionQuizFragmentToTestPassedFragment(arguments[0],arguments[1],arguments[2],arguments[3])
            )
            return
        }

        when(quizViewModel.currentQuestionType) {
            1 -> {

                //show first views
                val layout = layoutInflater.inflate(R.layout.question_type1,binding.root,false)
                binding.fragmentQuiz.removeAllViews()
                binding.fragmentQuiz.addView(layout)
                val questionTextView = layout.findViewById<TextView>(R.id.question_text_view)
                val answersIdList = (listOf(R.id.answer1_text_view,
                    R.id.answer2_text_view,
                    R.id.answer3_text_view,
                    R.id.answer4_text_view))// !!!
                val points = layout.findViewById<TextView>(R.id.points_text_view)

                val rightAnswerIndex = quizViewModel.currentQuestionAnswers.getAnswers()
                    .indexOf(quizViewModel.currentQuestionAnswers.getRightAnswer())

                questionTextView.setText(quizViewModel.currentQuestionResId)
                answersIdList.forEachIndexed { index, elem ->
                    layout.findViewById<TextView>(elem).apply {

                        val answerTextId = quizViewModel.currentQuestionAnswers.getAnswers()[index]
                        setText(answerTextId)
                        setOnClickListener {view: View ->
                            if(checkAnswer(getString(answerTextId),1)) {
                                //GREEN
                                setBackgroundResource(R.drawable.answer_background_green)
                            }

                            else {
                                layout.findViewById<TextView>(answersIdList[rightAnswerIndex])
                                    .setBackgroundResource(R.drawable.answer_background_green)
                                setBackgroundResource(R.drawable.answer_background_red)
                                //RED
                            }
                            (layout as MotionLayout).transitionToStart {
                                quizViewModel.currentIndex += 1
                                updateQuestion()
                            }

                        }
                    }
                }

                val pointsString = getString(R.string.points,quizViewModel.points)
                points.text = pointsString
            }
            2 -> {
                //show seconds views
                val layout = layoutInflater.inflate(R.layout.question_type2,binding.root,false)
                binding.fragmentQuiz.removeAllViews()
                binding.fragmentQuiz.addView(layout)

                val questionTextView = layout.findViewById<TextView>(R.id.question2_text_view)
                val submitButton = layout.findViewById<Button>(R.id.submit_button)
                val editTextView = layout.findViewById<TextInputEditText>(R.id.edit_text)
                var inputText = ""

                questionTextView.setText(quizViewModel.currentQuestionResId)
                editTextView.addTextChangedListener(object : TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        inputText = p0.toString().lowercase().trim()
                    }

                    override fun afterTextChanged(p0: Editable?) {

                    }

                })

                submitButton.setOnClickListener { view: View ->
                    checkAnswer(inputText,2)
                    quizViewModel.currentIndex += 1
                    updateQuestion()
                }

            }
            else -> {
                //
            }
        }
    }

    private fun checkAnswer(answerText: String, questionType: Int): Boolean {
        //ВСТАВИТЬ РАЗУКРАШКУ?!
        val rightAnswer = quizViewModel.currentQuestionAnswers.getRightAnswer()

        if (getString(rightAnswer) == answerText) {
            Toast.makeText(context,"YOU GODDAMN RIGHT!",Toast.LENGTH_SHORT).show()
            quizViewModel.rightAnswers += 1
            quizViewModel.points +=
                when(questionType) {
                    1 -> 5
                    2 -> 10
                    else -> 0
                }
            return true
            // GREEN LIGHT
        }

        else {
            Toast.makeText(context,"LOSER!",Toast.LENGTH_SHORT).show()
            // RED LIGHT
            return false
        }
    }
    companion object {
        const val REQUEST_KEY_POINTS = "REQUEST_KEY_POINTS"
        const val BUNDLE_KEY_POINTS = "BUNDLE_KEY_POINTS"
    }
}