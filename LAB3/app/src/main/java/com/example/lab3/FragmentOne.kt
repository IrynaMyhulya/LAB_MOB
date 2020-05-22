package com.example.lab3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    fun getResultData(): String {

        val triangleCheckbox = view?.findViewById<CheckBox>(R.id.cb_triangle)
        val rectangleCheckbox = view?.findViewById<CheckBox>(R.id.cb_rectangle)
        val squareCheckbox = view?.findViewById<CheckBox>(R.id.cb_square)
        val areaRadioButton = view?.findViewById<RadioButton>(R.id.radio_area)
        val perimeterRadioButton = view?.findViewById<RadioButton>(R.id.radio_perimeter)

        var result = ""
        var a = 10
        var b = 5

        if (!triangleCheckbox!!.isChecked and !rectangleCheckbox!!.isChecked and !squareCheckbox!!.isChecked) {
            Toast.makeText(activity, "No figure selected.", Toast.LENGTH_LONG).show()
        }
        if(areaRadioButton!!.isChecked){

            if (triangleCheckbox!!.isChecked) {
                var temp =  a*a*0.433
                result += "\n" + "Area of triangle: " + temp + ";\n"
            }
            if (rectangleCheckbox!!.isChecked) {
                var temp =  a*b
                result += "\n" + "Area of rectangle: " + temp + ";\n"
            }
            if (squareCheckbox!!.isChecked) {
                var temp =  a*a
                result += "\n" + "Area of square: " + temp + ";\n"
            }
        }
        if(perimeterRadioButton!!.isChecked){

            if (triangleCheckbox!!.isChecked) {
                var temp =  3*a
                result += "\n" + "Perimeter of triangle: " + temp + ";\n"
            }
            if (rectangleCheckbox!!.isChecked) {
                var temp =  2*(a+b)
                result += "\n" + "Perimeter of rectangle: " + temp + ";\n"
            }
            if (squareCheckbox!!.isChecked) {
                var temp =  4*a
                result += "\n" + "Perimeter of square: " + temp + ";\n"
            }
        }

        return result
    }
}

