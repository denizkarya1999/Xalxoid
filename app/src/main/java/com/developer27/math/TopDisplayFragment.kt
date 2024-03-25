package com.developer27.math
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.developer27.math.databinding.ActivityMainBinding
import com.developer27.math.databinding.TopdisplayfragmentBinding
import kotlin.math.abs
import kotlin.math.sqrt


class TopDisplayFragment : Fragment(){
    // Create the binding variable
    private lateinit var binding : TopdisplayfragmentBinding

    // Create a variable to contain multiple inputs
    var theNumber = ""

    // Create variables for first and secondary numbers
    var firstNumber = 0.0
    var secondNumber = 0.0

    // Create a variable for operation
    var Operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize the binding variable
        binding = TopdisplayfragmentBinding.inflate(inflater, container, false)

        // Final action
        return binding.root
    }

    fun loadScreen() {
        // Initialize the result variable as zero
        theNumber = ""
        firstNumber = 0.0
        secondNumber = 0.0
        Operation = ""
        binding.ResultScreen.text = 0.toString()
        binding.FirstNumber.text = ""
        binding.ProblemIndicator.text = ""
    }

    fun handleOperation(operation: String){
        if(operation == "addition"){
            if(theNumber.isEmpty()){
                showMessageBox("No first number","Please enter a number first then try this operation.")
                loadScreen()
            } else {
                binding.ProblemIndicator.text = "Addition"
                firstNumber = binding.ResultScreen.text.toString().toDouble()
                binding.FirstNumber.text = firstNumber.toString()
                theNumber = ""
                binding.ResultScreen.text = "0"
                Operation = binding.ProblemIndicator.text.toString()
            }
        } else if(operation == "subtraction"){
            if(theNumber.isEmpty()){
                showMessageBox("No first number","Please enter a number first then try this operation.")
                loadScreen()
            } else {
                binding.ProblemIndicator.text = "Subtraction"
                firstNumber = binding.ResultScreen.text.toString().toDouble()
                binding.FirstNumber.text = firstNumber.toString()
                binding.ResultScreen.text = "0"
                theNumber = ""
                binding.ResultScreen.text = "0"
                Operation = binding.ProblemIndicator.text.toString()
            }
        } else if(operation == "multiplication"){
            if(theNumber.isEmpty()){
                showMessageBox("No first number","Please enter a number first then try this operation.")
                loadScreen()
            } else {
                binding.ProblemIndicator.text = "Multiplication"
                firstNumber = binding.ResultScreen.text.toString().toDouble()
                binding.FirstNumber.text = firstNumber.toString()
                binding.ResultScreen.text = "0"
                theNumber = ""
                binding.ResultScreen.text = "0"
                Operation = binding.ProblemIndicator.text.toString()
            }
        }  else if(operation == "division"){
            if(theNumber.isEmpty()){
                showMessageBox("No first number","Please enter a number first then try this operation.")
                loadScreen()
            } else {
                binding.ProblemIndicator.text = "Division"
                firstNumber = binding.ResultScreen.text.toString().toDouble()
                binding.FirstNumber.text = firstNumber.toString()
                binding.ResultScreen.text = "0"
                theNumber = ""
                binding.ResultScreen.text = "0"
                Operation = binding.ProblemIndicator.text.toString()
            }
        }  else if(operation == "modulus"){
            if(theNumber.isEmpty()){
                showMessageBox("No first number","Please enter a number first then try this operation.")
                loadScreen()
            } else {
                binding.ProblemIndicator.text = "Modulus"
                firstNumber = abs( binding.ResultScreen.text.toString().toDouble())
                binding.FirstNumber.text = (firstNumber.toString())
                binding.ResultScreen.text = "0"
                theNumber = ""
                binding.ResultScreen.text = "0"
                Operation = binding.ProblemIndicator.text.toString()
            }
        }  else if(operation == "squareRoot"){
            if(theNumber.isEmpty()){
                showMessageBox("No first number","Please enter a number first then try this operation.")
                loadScreen()
            } else {
                binding.ProblemIndicator.text = "Square Root"
                firstNumber = binding.ResultScreen.text.toString().toDouble()
                Operation = binding.ProblemIndicator.text.toString()
            }
        }
    }

    fun generateResult(equalsOperation: String){
        if(equalsOperation == "="){
            if(Operation == "Addition"){
                secondNumber = binding.ResultScreen.text.toString().toDouble()
                val result = firstNumber + secondNumber
                binding.ResultScreen.text = String.format("%.2f", result)
                theNumber = ""
                firstNumber = 0.0
                secondNumber = 0.0
                Operation = ""
                binding.FirstNumber.text = ""
                binding.ProblemIndicator.text = ""
            } else if(Operation == "Subtraction"){
                secondNumber = binding.ResultScreen.text.toString().toDouble()
                val result = firstNumber - secondNumber
                binding.ResultScreen.text = String.format("%.2f", result)
                theNumber = ""
                firstNumber = 0.0
                secondNumber = 0.0
                Operation = ""
                binding.FirstNumber.text = ""
                binding.ProblemIndicator.text = ""
            } else if(Operation == "Multiplication"){
                secondNumber = binding.ResultScreen.text.toString().toDouble()
                val result = firstNumber * secondNumber
                binding.ResultScreen.text = String.format("%.2f", result)
                theNumber = ""
                firstNumber = 0.0
                secondNumber = 0.0
                Operation = ""
                binding.FirstNumber.text = ""
                binding.ProblemIndicator.text = ""
            } else if(Operation == "Division"){
                secondNumber = binding.ResultScreen.text.toString().toDouble()
                val result = firstNumber / secondNumber
                binding.ResultScreen.text = String.format("%.2f", result)
                theNumber = ""
                firstNumber = 0.0
                secondNumber = 0.0
                Operation = ""
                binding.FirstNumber.text = ""
                binding.ProblemIndicator.text = ""
            } else if(Operation == "Modulus"){
                secondNumber = abs(binding.ResultScreen.text.toString().toDouble())
                val result = firstNumber % secondNumber
                binding.ResultScreen.text = String.format("%.2f", result)
                theNumber = ""
                firstNumber = 0.0
                secondNumber = 0.0
                Operation = ""
                binding.FirstNumber.text = ""
                binding.ProblemIndicator.text = ""
            } else if(Operation == "Square Root"){
                val result = sqrt(firstNumber)
                binding.ResultScreen.text = String.format("%.2f", result)
                theNumber = ""
                firstNumber = 0.0
                secondNumber = 0.0
                Operation = ""
                binding.FirstNumber.text = ""
                binding.ProblemIndicator.text = ""
                if(binding.ResultScreen.text == "NaN"){
                    showMessageBox("Exceeding capacity","Unfortunately, this calculator cannot handle negative square roots")
                    loadScreen()
                }
            }
        }
    }

    fun typeOnScreen(receivedNumber: String) {
        if (theNumber.length > 15) {
            // Condition: If the length of theNumber exceeds 15 digits
            showMessageBox("Exceeding Length", "This calculator can only handle 15 digits!")
            loadScreen()
        } else if (theNumber.length > 1 && receivedNumber == ".") {
        // Condition: If the length of theNumber is greater than 1 and receivedNumber is "."
            if (!theNumber.contains(".")) {
                // If '.' is not already present in theNumber, append it
                theNumber += receivedNumber
                binding.ResultScreen.text = theNumber
            }
        } else if (theNumber.isNotEmpty() && theNumber != "0" && receivedNumber == ".") {
            // Condition: If theNumber is not empty, not equal to "0", and receivedNumber is "."
            if (!theNumber.contains(".")) {
                // If '.' is not already present in theNumber, append it
                theNumber += receivedNumber
                binding.ResultScreen.text = theNumber
            }
        } else if (theNumber == "0") {
            // Condition: If theNumber is "0"
            loadScreen()
        } else if (theNumber.isNotEmpty() && receivedNumber == "negative") {
            // Condition: If theNumber is not empty and receivedNumber is "-"
            // Check if '-' is already present at the beginning of theNumber
            if (!theNumber.startsWith("-")) {
                theNumber = "-$theNumber"
                binding.ResultScreen.text = theNumber
            }
        } else if (theNumber.isEmpty() && receivedNumber == "negative") {
            showMessageBox("Number Missing", "Please enter a number before using this operation.")
            loadScreen()
        }else {
            // Default condition: Append receivedNumber to theNumber
            theNumber += receivedNumber
            binding.ResultScreen.text = theNumber
        }
    }

    fun clearRecentDigit(){
        // Get the text from ResultScreen
        val currentText = binding.ResultScreen.text.toString()

        // Check if the current text is not empty
        if (currentText.isNotEmpty()) {
            // Remove the last character
            val updatedText = currentText.substring(0, currentText.length - 1)

            // Set the updated text back to the ResultScreen
            binding.ResultScreen.text = updatedText
            theNumber = updatedText
        }
    }

    // Show a message box
    fun showMessageBox(title: String, message: String) {
        val builder = AlertDialog.Builder(requireContext()) // or requireActivity() if you prefer
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->
            // You can perform additional actions if needed when the user clicks OK
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}