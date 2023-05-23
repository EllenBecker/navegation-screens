package com.example.navegationscreens;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

class ChurrasPrincipalFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflate = inflater.inflate(R.layout.fragment_churras_principal,container, false);

        var goToResultFragment = inflate.findViewById(R.id.button5) as Button;

        val numberHomem = inflate.findViewById(R.id.editTextNumberDecimal4) as EditText;
        val numberMulher = inflate.findViewById(R.id.editTextNumberDecimal5) as EditText;
        val numberCriança = inflate.findViewById(R.id.editTextNumberDecimal6) as EditText;

        goToResultFragment.setOnClickListener{
            val fm = fragmentManager;
            fm!!.beginTransaction().replace(R.id.fragmentContainer,
                ChurrasResultFragment.newInstance(numberHomem.text.toString().toDouble(), numberMulher.text.toString().toDouble(),numberCriança.text.toString().toDouble()),"ChurrasResultFragment")
                .addToBackStack(null).commit()
        }
        return inflate;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChurrasPrincipalFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}