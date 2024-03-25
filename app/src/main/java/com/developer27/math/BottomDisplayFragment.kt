package com.developer27.math
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.developer27.math.databinding.BottomdisplayfragmentBinding
import com.developer27.math.databinding.TopdisplayfragmentBinding

class BottomDisplayFragment : Fragment() {
    // Create the binding variable
    private lateinit var binding : BottomdisplayfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize the binding variable
        binding = BottomdisplayfragmentBinding.inflate(inflater, container, false)

        // When user presses 1 take action
        binding.OneButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(1.toString())
        }

        // When user presses 2 take action
        binding.TwoButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(2.toString())
        }

        // When user presses 3 take action
        binding.ThreeButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(3.toString())
        }

        // When user presses 4 take action
        binding.FourButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(4.toString())
        }

        // When user presses 5 take action
        binding.FiveButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(5.toString())
        }

        // When user presses 6 take action
        binding.SixButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(6.toString())
        }

        // When user presses 7 take action
        binding.SevenButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(7.toString())
        }

        // When user presses 8 take action
        binding.EightButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(8.toString())
        }

        // When user presses 9 take action
        binding.NineButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(9.toString())
        }

        // When user presses 0 take action
        binding.ZeroButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("0")
        }

        // When user presses . take action
        binding.DotButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput(".")
        }

        // When user presses CE take action
        binding.CButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("C")
        }

        // When the user clicks on plus or minus button take action
        binding.PlusOrMinusButton.setOnClickListener {
            if(binding.PlusOrMinusButton.text == "(-)"){
                binding.PlusOrMinusButton.text = "(+)"
                val mainActivity = activity as MainActivity
                mainActivity.setUserInput("negative")
            } else {
                binding.PlusOrMinusButton.text = "(-)"
            }
        }

        // When the user clicks on addition button take action
        binding.AddButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("+")
        }

        // When the user clicks on subtraction button take action
        binding.SubtractButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("-")
        }

        // When the user clicks on multiplication button take action
        binding.MultiplicationButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("*")
        }

        // When the user clicks on division button take action
        binding.DivisionButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("/")
        }

        // When the user clicks on modulus button take action
        binding.ModulusButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("%")
        }

        // When the user clicks on squareRoot button take action
        binding.SquareRootButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("sqrt")
        }

        // When the user clicks on equals operation, take action
        binding.EqualsButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("equals")
        }

        // When the user clicks on CE operation, take action
        binding.CeButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setUserInput("CE")
        }

        // Final action
        return binding.root
    }
}