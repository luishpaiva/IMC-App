package com.projects.imcapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.projects.imcapp.R;

public class aboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void voltarButtonOnClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

}