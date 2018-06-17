package com.example.rene.steppenwolf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class quiz_allgemein extends AppCompatActivity implements View.OnClickListener {

    android.support.v7.widget.Toolbar toolbar;

    int questionIndex = 0;
    int correct = 0;


    TextView frage;
    Button ba1;
    Button ba2;
    Button ba3;
    Button ba4;


    int anzahlFragen = 8;
    String[] fragen = new String[anzahlFragen];
    String[] richtigeAntworten = new String[anzahlFragen];
    ArrayList<String[]> antworten = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        setToolbar();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });

        ba1 = findViewById(R.id.antwort1);
        ba1.setOnClickListener(this);
        ba2 = findViewById(R.id.antwort2);
        ba2.setOnClickListener(this);
        ba3 = findViewById(R.id.antwort3);
        ba3.setOnClickListener(this);
        ba4 = findViewById(R.id.antwort4);
        ba4.setOnClickListener(this);

        fragen = getResources().getStringArray(R.array.allgemein_quiz_fragen);
        richtigeAntworten = getResources().getStringArray(R.array.allg_correct_answers);

        String[] temp = getResources().getStringArray(R.array.allg_antwort_1);
        antworten.add(temp);
        temp = getResources().getStringArray(R.array.allg_antwort_1);
        antworten.add(temp);
        temp = getResources().getStringArray(R.array.allg_antwort_1);
        antworten.add(temp);
        temp = getResources().getStringArray(R.array.allg_antwort_2);
        antworten.add(temp);
        temp = getResources().getStringArray(R.array.allg_antwort_3);
        antworten.add(temp);
        temp = getResources().getStringArray(R.array.allg_antwort_4);
        antworten.add(temp);

        frage = findViewById(R.id.frage);

        putQuestion();
    }

    private void putQuestion() {
        if (questionIndex > fragen.length) return;

        frage.setText(fragen[questionIndex]);

        ba1.setText(antworten.get(questionIndex)[0]);
        ba2.setText(antworten.get(questionIndex)[1]);
        ba3.setText(antworten.get(questionIndex)[2]);
        ba4.setText(antworten.get(questionIndex)[3]);
    }

    private void setToolbar() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Quiz");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_18dp);
        toolbar.setId(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        String answer = "";
        if (v.getClass() == AppCompatButton.class) {
            Button x = (Button) v;
            answer = ((Button) v).getText().toString();
        }
        if (checkAnswer(answer)) {
            correct++;
        }
        questionIndex++;
        if (questionIndex == fragen.length) {
            Log.d("Quiz-Ergebnis", String.format("%d von %d Antworten korrekt", correct, fragen.length));
            Toast t = Toast.makeText(getApplicationContext(), String.format(Locale.GERMANY, "%d von %d Antworten korrekt", correct, fragen.length), Toast.LENGTH_LONG);
            t.show();

            correct = 0;
            questionIndex = 0;
            putQuestion();
        } else {
            putQuestion();
        }

    }

    private boolean checkAnswer(String answer) {
        return answer.equals(antworten.get(questionIndex)[Integer.parseInt(richtigeAntworten[questionIndex]) - 1]);
    }
}

