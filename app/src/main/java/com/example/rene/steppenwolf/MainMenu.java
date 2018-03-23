package com.example.rene.steppenwolf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Button> btns;
    android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setToolbar();
        initButtons();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });
    }

    private void setToolbar(){
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Der Steppenwolf");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_18dp);
        toolbar.setId(R.id.toolbar);
    }

    private void initButtons(){

        Button temp;

        temp = findViewById(R.id.erzaehltechnik);
        temp.setOnClickListener(this);

        temp = (Button) findViewById(R.id.struktur_aufbau);
        temp.setOnClickListener(this);

        temp = (Button) findViewById(R.id.symbole_motive);
        temp.setOnClickListener(this);

        temp = (Button) findViewById(R.id.sprache_stil);
        temp.setOnClickListener(this);

        temp = (Button) findViewById(R.id.inhalt);
        temp.setOnClickListener(this);

        temp = (Button) findViewById(R.id.biographie);
        temp.setOnClickListener(this);

        temp = (Button) findViewById(R.id.aufsatztechnik);
        temp.setOnClickListener(this);

        temp = (Button) findViewById(R.id.figuren);
        temp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //Toast.makeText(getApplicationContext(), String.format("%d", view.getId()), Toast.LENGTH_LONG).show();

        switch(view.getId()) {
            case R.id.erzaehltechnik:
                //open erzaehltechnik activity
                Intent intent = new Intent(getApplicationContext(), erzaehltechnik.class);
                startActivity(intent);
                break;
            case R.id.struktur_aufbau:
                //open activity

                break;
            case  R.id.symbole_motive:

                break;
            case R.id.sprache_stil:

                break;
            case R.id.inhalt:
                Intent inhalt = new Intent(getApplicationContext(), inhalt.class);
                startActivity(inhalt);
                break;
            case R.id.biographie:

                break;
            case R.id.aufsatztechnik:
                Intent aufs = new Intent(getApplicationContext(), aufsatztechnik.class);
                startActivity(aufs);
                break;
            case R.id.figuren:

                break;
        }
    }
}
