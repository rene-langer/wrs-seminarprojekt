package com.example.rene.steppenwolf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pre_figures extends AppCompatActivity implements View.OnClickListener {


    android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_figures);

        Button temp;
        temp = findViewById(R.id.reale_figuren);
        temp.setOnClickListener(this);
        temp = findViewById(R.id.nicht_reale_figuren);
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
        toolbar.setTitle("Figuren");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_18dp);
        toolbar.setId(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.reale_figuren) {
            Intent figs = new Intent(getApplicationContext(), figures.class);
            startActivity(figs);
        }
        if (v.getId() == R.id.nicht_reale_figuren) {
            Intent sfigs = new Intent(getApplicationContext(), subfigures.class);
            startActivity(sfigs);
        }
    }
}
