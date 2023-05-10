package com.example.navegationscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PrincipalFragment : Fragment() {

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
        var inflate = inflater.inflate(R.layout.fragment_principal,container, false);

        var goToButton = inflate.findViewById(R.id.button) as Button;

        val texto = inflate.findViewById(R.id.editTextTextPersonName) as EditText;
        val texto2 = inflate.findViewById(R.id.editTextTextPersonName2) as EditText;

        goToButton.setOnClickListener{
            val fm = fragmentManager;
            fm!!.beginTransaction().replace(R.id.fragmentContainer,
                DetalheFragment.newInstance(texto.text.toString(), texto2.text.toString()),"DetalheFragment")
                .addToBackStack(null).commit()
        }

        return inflate;
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            PrincipalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1);
                }
            }
    }
}