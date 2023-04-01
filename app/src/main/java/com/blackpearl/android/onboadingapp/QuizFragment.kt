package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import org.w3c.dom.Text

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
            setFragmentResult(REQUEST_KEY_POINTS, bundleOf(BUNDLE_KEY_POINTS to quizViewModel.points))
            findNavController().popBackStack()
            return
        }

        when(quizViewModel.currentQuestionType) {
            1 -> {
                //show first views
                val layout = layoutInflater.inflate(R.layout.question_type1,binding.root,false)
                binding.fragmentQuiz.removeAllViews()
                binding.fragmentQuiz.addView(layout)
                val questionText = layout.findViewById<TextView>(R.id.question_text_view)
                val answersIdList = listOf(R.id.answer1_text_view,
                    R.id.answer2_text_view,
                    R.id.answer3_text_view,
                    R.id.answer4_text_view)
                val points = layout.findViewById<TextView>(R.id.points_text_view)

                questionText.setText(quizViewModel.currentQuestionResId)
                answersIdList.forEachIndexed { index, elem ->
                    layout.findViewById<TextView>(elem).apply {
                        val answerTextId = quizViewModel.currentQuestionAnswers.getAnswers()[index]
                        setText(answerTextId)
                        setOnClickListener {view: View ->
                            (layout as MotionLayout).transitionToStart {

                                checkAnswer(answerTextId,1)
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
            }
            else -> {
                //
            }
        }
    }

    private fun checkAnswer(answerTextId: Int,questionType : Int) {
        //ВСТАВИТЬ РАЗУКРАШКУ?!
        val rightAnswer = quizViewModel.currentQuestionAnswers.getRightAnswer()

        if (getString(rightAnswer) == getString(answerTextId)) {
            Toast.makeText(context,"YOU GODDAMN RIGHT!",Toast.LENGTH_SHORT).show()
            quizViewModel.points +=
                when(questionType) {
                    1 -> 5
                    2 -> 10
                    else -> 0
                }
            // GREEN LIGHT
        }

        else {
            Toast.makeText(context,"LOSER!",Toast.LENGTH_SHORT).show()
            // RED LIGHT
        }
    }

    companion object {
        const val REQUEST_KEY_POINTS = "REQUEST_KEY_POINTS"
        const val BUNDLE_KEY_POINTS = "BUNDLE_KEY_POINTS"
    }
}