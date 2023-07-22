package com.projects.imcapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.projects.imcapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularIMCOnClick(View v) {
        EditText nomeEditText = findViewById(R.id.nomeEditText);
        EditText alturaEditText = findViewById(R.id.alturaEditNumber);
        EditText pesoEditText = findViewById(R.id.pesoEditNumber);

        String nome = nomeEditText.getText().toString();
        float altura;
        float peso;
        float imc;

        if (alturaEditText.getText().toString().equals("")) {
            altura = 0;
        } else {
            altura = Float.parseFloat(alturaEditText.getText().toString()) / 100;
        }

        if (pesoEditText.getText().toString().equals("")) {
            peso = 0;
        } else {
            peso = Float.parseFloat(pesoEditText.getText().toString());
        }

        if (peso <= 0 || altura <= 0) {
            Toast.makeText(
                    MainActivity.this,
                    getString(R.string.imc_zero),
                    Toast.LENGTH_LONG).show();
        } else {
            imc = peso / (altura * altura);

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("nome", nome);
            bundle.putFloat("altura", altura);
            bundle.putFloat("imc", imc);

            intent.putExtras(bundle);
            startActivity(intent);

            nomeEditText.setText("");
            alturaEditText.setText("");
            pesoEditText.setText("");
        }

    }

    public void sobreNosOnClick(View v) {
        Intent intent = new Intent(MainActivity.this, aboutUsActivity.class);
        startActivity(intent);
    }

}
