package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.lab3.FragmentTwo.Companion.concatenate
import java.io.File

const val fileName = "orders.txt"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startCalc(view: View) {
        val checkRadioFragment =
            supportFragmentManager.findFragmentById(R.id.checkbox_fragment) as FragmentOne
        val resultData = checkRadioFragment.getResultData()

        writeToFile(resultData)
        displayResults(resultData)
    }

    fun showResults(view: View) {
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }

    private fun displayResults(resultData: String) {
        var check_field = ""
        var resultsFragment =
            supportFragmentManager.findFragmentById(R.id.results_fragment) as FragmentTwo
        if (FragmentTwo.concatenate(
                check_field,
                resultData
            ) != resultsFragment.displayText
        ) {
            resultsFragment = FragmentTwo.newInstance(concatenate(check_field, resultData))

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.results_fragment, resultsFragment)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }

    private fun writeToFile(resultData: String) {
        if (resultData != "") {
            val text = resultData
            val file = File(baseContext.filesDir, fileName)
            if (file.exists()) {
                file.appendText(text + '\n')
            } else {
                file.writeText(text)
            }
        }
    }
}
