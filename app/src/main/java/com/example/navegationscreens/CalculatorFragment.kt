package com.example.navegationscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CalculatorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_calculator, container, false);

        val buttonExecute = inflate.findViewById(R.id.button2) as Button
        buttonExecute.setOnClickListener { view ->
            var number1 = inflate.findViewById(R.id.editTextNumberDecimal) as EditText;
            var number2 = inflate.findViewById(R.id.editTextNumberDecimal2) as EditText;

            val number1Double = number1.text.toString().toDouble();
            val number2Double = number2.text.toString().toDouble();

            val sum = sumNumbers(number1Double,number2Double);
            val div = divNumbers(number1Double,number2Double);
            val mult = multNumbers(number1Double,number2Double);
            val sub = subNumbers(number1Double,number2Double);

            val message = "Soma: ${sum.toString()} " +
                    "| Divisão: ${div.toString()} " +
                    "| Multiplicação: ${mult.toString()} " +
                    "| Subtração: ${sub.toString()}"
            Snackbar.make(view, message,
                Snackbar.LENGTH_INDEFINITE
            ).setAction("Action", null).show()

        }

        return inflate;
    }

    fun sumNumbers(number1: Double,number2:Double): Double {
        return number1.plus(number2);
    }

    fun divNumbers(number1: Double,number2:Double): Double {
        return number1.div(number2);
    }

    fun multNumbers(number1: Double,number2:Double): Double {
        return number1.times(number2);
    }

    fun subNumbers(number1: Double,number2:Double): Double {
        return number1.minus(number2);
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CalculatorFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}