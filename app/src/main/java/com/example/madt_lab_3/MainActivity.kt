package com.example.madt_lab_3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity() {
    private var memoryValue = 0.0
    private var currentInput = ""
    private var currentResult = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var memoryValue = 0.0

        val resultDisplay = findViewById<TextView>(R.id.ResultDisplay)

        val mcButton = findViewById<Button>(R.id.button0_1)

        // Set a click listener for the "MC" button
        mcButton.setOnClickListener {
            memoryValue = 0.0
        }


        val mrButton = findViewById<Button>(R.id.button0_2)

        mrButton.setOnClickListener {
            resultDisplay.text = memoryValue.toString()

        }

        val msButton = findViewById<Button>(R.id.button0_3)

        msButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val currentValue = currentText.toDoubleOrNull()
            if (currentValue != null) {
                memoryValue = currentValue
            }
        }

        val mplusButton = findViewById<Button>(R.id.button0_4)

        mplusButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val currentValue = currentText.toDoubleOrNull()
            if (currentValue != null) {
                memoryValue += currentValue
            }
        }

        val mMinusButton = findViewById<Button>(R.id.button0_5)

        mMinusButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val currentValue = currentText.toDoubleOrNull()
            if (currentValue != null) {
                memoryValue -= currentValue
            }
        }

        //DEL BUTTON
        //Deletes the most recent input

        val delButton = findViewById<Button>(R.id.button1_0)

        delButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            if (currentText.isNotEmpty()) {
                val updatedText = currentText.substring(0, currentText.length - 1)
                resultDisplay.text = updatedText
            }

        }

        val ceButton = findViewById<Button>(R.id.button1_1)

        ceButton.setOnClickListener {
            resultDisplay.text = ""
        }

        val cButton = findViewById<Button>(R.id.button1_2)

        cButton.setOnClickListener {
            resultDisplay.text = ""
        }

        val pnButton = findViewById<Button>(R.id.button1_3)

        pnButton.setOnClickListener {
            val text = resultDisplay.text.toString()
            val intValue = text.toInt()

            if (intValue > 0) {
                val negativeNumber = -intValue
                val result = negativeNumber.toString()
                resultDisplay.text = result
            } else {
                val positiveNumber = -intValue
                val result = positiveNumber.toString()
                resultDisplay.text = result
            }

        }

        val sqrtButton = findViewById<Button>(R.id.button1_4)

        sqrtButton.setOnClickListener {
            var currentInput = resultDisplay.text.toString() // Change 'val' to 'var'
            if (currentInput.isNotEmpty()) {
                val inputNumber = currentInput.toDouble()
                if (inputNumber >= 0.0) {
                    val sqrtResult = Math.sqrt(inputNumber)
                    resultDisplay.text = sqrtResult.toString()
                    currentInput = sqrtResult.toString() // You can now reassign it
                } else {
                    // Handle square root of a negative number
                    resultDisplay.text = "Error: Square root of a negative number"
                }
            }
        }


        val sevenButton = findViewById<Button>(R.id.button2_0)

        sevenButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            // Append "8" to the current text
            val newText = currentText + "7"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val eightButton = findViewById<Button>(R.id.button2_1)

        eightButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            // Append "8" to the current text
            val newText = currentText + "8"

            // Update the TextView with the new text
            resultDisplay.text = newText

        }

        val nineButton = findViewById<Button>(R.id.button2_2)

        nineButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            
            val newText = currentText + "9"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val divisionButton = findViewById<Button>(R.id.button2_3)

        divisionButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val divisionText = getString(R.string.division_operator, currentText)
            resultDisplay.text = divisionText
        }

        val cocientButton = findViewById<Button>(R.id.button2_4)

        cocientButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val cocientText = getString(R.string.cocient_operator, currentText)
            resultDisplay.text = cocientText
        }

        val fourButton = findViewById<Button>(R.id.button3_0)

        fourButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            // Append "8" to the current text
            val newText = currentText + "4"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val fiveButton = findViewById<Button>(R.id.button3_1)

        fiveButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

           
            val newText = currentText + "5"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val sixButton = findViewById<Button>(R.id.button3_2)

        sixButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            // Append "8" to the current text
            val newText = currentText + "6"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val multiplicationButton = findViewById<Button>(R.id.button3_3)

        multiplicationButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val multiplicationText = getString(R.string.multiplication_operator, currentText)
            resultDisplay.text = multiplicationText
        }

        val divbyoneButton = findViewById<Button>(R.id.button3_4)

        divbyoneButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val divisionByOneText = getString(R.string.division_by_one_operator, currentText)
            resultDisplay.text = divisionByOneText
        }
        val oneButton = findViewById<Button>(R.id.button4_0)

        oneButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            // Append "8" to the current text
            val newText = currentText + "1"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val twoButton = findViewById<Button>(R.id.button4_1)

        twoButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            // Append "8" to the current text
            val newText = currentText + "2"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val threeButton = findViewById<Button>(R.id.button4_2)

        threeButton.setOnClickListener {
            // Get the current text from the TextView
            val currentText = resultDisplay.text.toString()

            /
            val newText = currentText + "3"

            // Update the TextView with the new text
            resultDisplay.text = newText
        }

        val minusButton = findViewById<Button>(R.id.button4_3)
        minusButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val minusText = getString(R.string.minus_operator, currentText)
            resultDisplay.text = minusText

        }

        val ceroButton = findViewById<Button>(R.id.button5_1)

        ceroButton.setOnClickListener {

            val currentText = resultDisplay.text.toString()


            val newText = currentText + "0"


            resultDisplay.text = newText
        }

        val commaButton = findViewById<Button>(R.id.button5_2)

        commaButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val commaText = getString(R.string.comma_operator, currentText)
            resultDisplay.text = commaText
        }
        val plusButton = findViewById<Button>(R.id.button5_3)

        plusButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val plusText = getString(R.string.plus_operator, currentText)
            resultDisplay.text = plusText
        }

        val equalButton = findViewById<Button>(R.id.button5_4)

        equalButton.setOnClickListener {
            val currentText = resultDisplay.text.toString()
            val expression = currentText.replace(" ", "")  // Remove spaces for easier processing
            val operators = listOf("+", "-", "*", "/", "%", "1/x", "sqrt")

            var result = 0.0
            var currentOperator = "+"

            if (expression.contains(Regex("[${operators.joinToString("\\")}]+"))) {
                // If the expression contains any operator, perform the calculation
                val tokens = expression.split(Regex("[$operators]"))

                for (token in tokens) {
                    val operatorIndex =
                        expression.indexOfFirst { operators.contains(it.toString()) }

                    if (operatorIndex != -1) {
                        currentOperator = expression[operatorIndex].toString()
                    }

                    val operand = token.toDouble()

                    when (currentOperator) {
                        "+" -> result += operand
                        "*" -> result = if (result == 0.0) operand else result * operand
                        "/" -> result = if (result == 0.0) operand else result / operand
                        "%" -> result = result * operand / 100.0
                        "-"->  result -= operand
                        "1/x" -> result = if (result == 0.0) 0.0 else 1.0 / result
                    }


                    resultDisplay.text = result.toString()
                }


            }


        }
    }
}
