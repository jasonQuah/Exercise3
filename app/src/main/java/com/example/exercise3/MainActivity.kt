package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = findViewById<Spinner>(R.id.spinnerAge)
        val gender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val smoker = findViewById<CheckBox>(R.id.checkBoxSmoker)

        val insurance = findViewById<TextView>(R.id.textViewPremium)

        val calculate = findViewById<Button>(R.id.buttonCalculate)
        val clear = findViewById<Button>(R.id.buttonReset)

        calculate.setOnClickListener(){
            val<Int> age = a.selectedItemPosition
            var<Double> total = 0.00

            when(age){
                0 -> {total += 60}
                1 -> {total += 70}
                2 -> {total += 90}
                3 -> {total += 120}
                4 -> {total += 150}
                5 -> {total += 150}
            }

            if(gender.radioButtonMale.isChecked){
                when(age){
                    0 -> {total += 0}
                    1 -> {total += 50}
                    2 -> {total += 100}
                    3 -> {total += 150}
                    4 -> {total += 200}
                    5 -> {total += 200}
                }
            } else {
                total += 0
            }

            if(smoker.isChecked){
                when(age){
                    0 -> {total += 0}
                    1 -> {total += 100}
                    2 -> {total += 150}
                    3 -> {total += 200}
                    4 -> {total += 250}
                    5 -> {total += 300}
                }
            } else {
                total += 0
            }

            insurance.setText(String.format("Insurance Premium: RM%.2f", (total)))
        }

        clear.setOnClickListener(){
            a.setSelection(0)
            gender.clearCheck()
            smoker.isChecked = false
            insurance.setText(R.string.insurance_premium)
        }
    }
}
