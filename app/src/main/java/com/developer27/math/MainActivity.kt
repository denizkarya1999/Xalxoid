package com.developer27.math
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.FragmentActivity
import com.developer27.math.R.id.ResultScreen
import com.developer27.math.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Create the binding variable
    private lateinit var binding: ActivityMainBinding

    // Declare a variable for the user input
    private var userInput = ""

    // Declare variables for fragments
    private lateinit var topDisplayFragment: TopDisplayFragment
    private lateinit var bottomDisplayFragment: BottomDisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        // Initialize the binding variable
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the fragments
        topDisplayFragment =
            supportFragmentManager.findFragmentById(R.id.TopDisplayFragment) as TopDisplayFragment
        bottomDisplayFragment = BottomDisplayFragment()

        // Set initial values upon loading
        InitialSetup()

        // Add BottomDisplayFragment programmatically
        supportFragmentManager.beginTransaction()
            .add(R.id.BottomDisplayFragment, bottomDisplayFragment)
            .commit()
    }

    // Receive the userInput from other fragments
    fun setUserInput(value: String) {
        userInput = value
        HandleInput(userInput)
    }

    private fun HandleInput(receivedInput: String) {
        if (receivedInput == "C") {
            topDisplayFragment.loadScreen()
        } else if(receivedInput == "CE"){
            topDisplayFragment.clearRecentDigit()
        } else if (receivedInput == "+") {
            topDisplayFragment.handleOperation("addition")
        } else if (receivedInput == "-") {
            topDisplayFragment.handleOperation("subtraction")
        } else if (receivedInput == "*") {
            topDisplayFragment.handleOperation("multiplication")
        } else if (receivedInput == "/") {
            topDisplayFragment.handleOperation("division")
        } else if (receivedInput == "%") {
            topDisplayFragment.handleOperation("modulus")
        } else if (receivedInput == "sqrt") {
            topDisplayFragment.handleOperation("squareRoot")
        } else if (receivedInput == "negative"){
            topDisplayFragment.typeOnScreen("negative")
        } else if (receivedInput == "equals"){
            topDisplayFragment.generateResult("=")
        } else {
            topDisplayFragment.typeOnScreen(receivedInput)
        }
    }

    private fun InitialSetup(){
        topDisplayFragment.loadScreen()
    }
}