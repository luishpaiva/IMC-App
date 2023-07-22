package com.projects.imcapp.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.projects.imcapp.R;
import com.projects.imcapp.model.verificaPeso;

public class ResultActivity extends AppCompatActivity {

    TextView imcTextView, explicacaoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        String nome = extras.getString("nome");
        float altura = extras.getFloat("altura");
        float imc = extras.getFloat("imc");

        imcTextView = findViewById(R.id.imcTextView);
        explicacaoTextView = findViewById(R.id.explicacaoTextView);

        float pesoMinimo = verificaPeso.minimo(altura);
        float pesoMaximo = verificaPeso.maximo(altura);
        verificaIMC(nome, imc, pesoMinimo, pesoMaximo);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void verificaIMC(String nome, float imc, float pesoMinimo, float pesoMaximo) {

        imcTextView.setText(String.format("Olá, %s! O seu IMC é igual a: %.2f", nome, imc));

        if (imc < 18.5) {
            explicacaoTextView.setText(String.format(
                    "MAGREZA - De acordo com a Organização Mundial da Saúde, seu IMC está " +
                    "abaixo do recomendado para a sua altura. Para atingir um valor de IMC " +
                    "normal, seu peso deve estar entre %.2f e %.2f.",
                    pesoMinimo, pesoMaximo));
        } else if (imc <= 24.9) {
            explicacaoTextView.setText(String.format(
                    "NORMAL - De acordo com a Organização Mundial da Saúde, seu IMC é considerado " +
                    "normal para a sua altura. Para manter o valor de IMC normal, seu peso " +
                    "pode variar entre %.2f e %.2f kg.",
                    pesoMinimo, pesoMaximo));
        } else if (imc <= 29.9) {
            explicacaoTextView.setText(String.format(
                    "SOBREPESO - De acordo com a Organização Mundial da Saúde, seu IMC está um " +
                    "pouco acima do recomendado para a sua altura. Para atingir um valor de IMC " +
                    "normal, seu peso deve estar entre %.2f e %.2f kg.",
                    pesoMinimo, pesoMaximo));
        } else if (imc <= 34.9) {
            explicacaoTextView.setText(String.format(
                    "OBESIDADE GRAU I - De acordo com a Organização Mundial da Saúde, seu IMC " +
                    "está acima do recomendado para a sua altura. Para atingir um valor de IMC " +
                    "normal, seu peso deve estar entre %.2f e %.2f.",
                    pesoMinimo, pesoMaximo));
        } else if (imc <= 39.9) {
            explicacaoTextView.setText(String.format(
                    "OBESIDADE GRAU II - De acordo com a Organização Mundial da Saúde, seu IMC " +
                    "está bem acima do recomendado para a sua altura. Para atingir um valor de " +
                    "IMC normal, seu peso deve estar entre %.2f e %.2f.",
                    pesoMinimo, pesoMaximo));
        } else {
            explicacaoTextView.setText(String.format(
                    "OBESIDADE GRAU III - De acordo com a Organização Mundial da Saúde, seu IMC " +
                    "está extremamente acima do recomendado para a sua altura. Para atingir um " +
                    "valor de IMC normal, seu peso deve estar entre %.2f e %.2f.",
                    pesoMinimo, pesoMaximo));
        }
    }

    public void voltarOnClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

}
