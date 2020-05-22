package com.example.lab3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

const val TEXT_KEY = "TEXT"

class FragmentTwo : Fragment() {
    val displayText: String by lazy {
        arguments?.getString(TEXT_KEY) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        val fileDataResults = view.findViewById<TextView>(R.id.results)
        fileDataResults.text = displayText

        return view
    }

    companion object {
        fun newInstance(composedText: String): FragmentTwo {
            val fragment = FragmentTwo()

            val args = Bundle()
            args.putString(TEXT_KEY, composedText)

            fragment.arguments = args

            return fragment
        }

        fun concatenate(check_field: String, resultData: String): String {
            return "$check_field\n$resultData"
        }
    }
}