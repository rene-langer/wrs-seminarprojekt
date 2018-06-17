package com.example.rene.steppenwolf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class pre_quiz extends AppCompatActivity implements View.OnClickListener {


    android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_quiz);

        Button temp;
        temp = findViewById(R.id.quiz_allgemein);
        temp.setOnClickListener(this);
        temp = findViewById(R.id.quiz_hermine);
        temp.setOnClickListener(this);

        setToolbar();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });
    }

    private void setToolbar() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Quiz-Auswahl");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_18dp);
        toolbar.setId(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.quiz_allgemein) {
            Intent figs = new Intent(getApplicationContext(), quiz_allgemein.class);
            startActivity(figs);
        }
        if (v.getId() == R.id.quiz_hermine) {
            Intent sfigs = new Intent(getApplicationContext(), quiz_hermine.class);
            startActivity(sfigs);
        }
    }
}
