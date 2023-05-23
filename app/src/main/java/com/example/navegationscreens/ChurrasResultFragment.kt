package com.example.navegationscreens;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

private const val ARG_PARAM1 = "param1";
private const val ARG_PARAM2 = "param2";
private const val ARG_PARAM3 = "param3";

class ChurrasResultFragment : Fragment() {
    private var param1: Double = 0.0;
    private var param2: Double = 0.0;
    private var param3: Double = 0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getDouble(ARG_PARAM1)
            param2 = it.getDouble(ARG_PARAM2)
            param3 = it.getDouble(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_churras_result, container, false);

        val qtdCarne = inflate.findViewById(R.id.textView8) as TextView;
        var qtdSalame = inflate.findViewById(R.id.textView13) as TextView;
        var qtdCerveja = inflate.findViewById(R.id.textView14) as TextView;
        var qtdRefri = inflate.findViewById(R.id.textView15) as TextView;

        val qtdHomem = param1.toInt().toString();
        val qtdMulher = param2.toInt().toString();
        val qtdCrianca = param3.toInt().toString();

        qtdCarne.text = calCarne(qtdHomem.toDouble(), qtdMulher.toDouble(), qtdCrianca.toDouble());
        qtdSalame.text = calSalame(qtdHomem.toDouble(), qtdMulher.toDouble(), qtdCrianca.toDouble());
        qtdCerveja.text = calCerveja(qtdHomem.toDouble(), qtdMulher.toDouble());
        qtdRefri.text = calRefri(qtdHomem.toDouble(), qtdMulher.toDouble(), qtdCrianca.toDouble());

        return inflate;
    }

    fun calCarne(qtdHomem: Double, qtdMulher: Double, qtdCrianca: Double): String {
        val qtdCarneHomem = qtdHomem.times(300);
        val qtdCarneMulher = qtdMulher.times(280);
        val qtdCarneCrianca = qtdCrianca.times(150);
        return qtdCarneHomem.plus(qtdCarneMulher.plus(qtdCarneCrianca)).toInt().toString() + " gr";
    }

    fun calSalame(qtdHomem: Double, qtdMulher: Double, qtdCrianca: Double): String {
        val qtdSalameHomem = qtdHomem.times(200);
        val qtdSalameMulher = qtdMulher.times(180);
        val qtdSalameCrianca = qtdCrianca.times(100);
        return qtdSalameHomem.plus(qtdSalameMulher.plus(qtdSalameCrianca)).toInt().toString() + " gr";
    }

    fun calCerveja(qtdHomem: Double, qtdMulher: Double): String {
        val qtdCervejaHomem = qtdHomem.times(1500);
        val qtdCervejaMulher = qtdMulher.times(1000);
        return qtdCervejaHomem.plus(qtdCervejaMulher).toInt().toString() + " ml";
    }

    fun calRefri(qtdHomem: Double, qtdMulher: Double, qtdCrianca: Double): String {
        val qtdRefriHomem = qtdHomem.times(250);
        val qtdRefriMulher = qtdMulher.times(450);
        val qtdRefriCrianca = qtdCrianca.times(300);
        return qtdRefriHomem.plus(qtdRefriMulher.plus(qtdRefriCrianca)).toInt().toString() + " ml";
    }

    companion object {
        @JvmStatic
        fun newInstance(numberHomem: Double, numberMulher: Double, numberCriancas: Double) =
            ChurrasResultFragment().apply {
                arguments = Bundle().apply {
                    putDouble(ARG_PARAM1, numberHomem)
                    putDouble(ARG_PARAM2, numberMulher)
                    putDouble(ARG_PARAM3, numberCriancas)
                }
            }
    }
}