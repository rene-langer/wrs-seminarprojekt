package com.example.rene.steppenwolf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class figures extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;

    ExpandableListAdapter adapter;
    ExpandableListView expListView;
    ArrayList<String> headlines;
    HashMap<String, List<String>> childs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);

        setToolbar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        expListView = findViewById(R.id.list_view);
        prepare();

        adapter = new ExpandableListAdapter(getApplicationContext(), headlines, childs);

        expListView.setAdapter(adapter);
    }

    private void prepare() {
        headlines = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.figures_headlines)));
        ArrayList<String> texts = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.figures_texts)));

        childs = new HashMap<>();


        if (texts.size() == headlines.size()) {
            for (int i = 0; i < texts.size(); i++) {
                childs.put(headlines.get(i), new ArrayList<>(Arrays.asList(texts.get(i))));
            }
        } else {
            Toast.makeText(getApplicationContext(), "Dimensions do not match.", Toast.LENGTH_LONG).show();
        }
    }


    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Figuren");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_18dp);
        toolbar.setId(R.id.toolbar);
    }
}
