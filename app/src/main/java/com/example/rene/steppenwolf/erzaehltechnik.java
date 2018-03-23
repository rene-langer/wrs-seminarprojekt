package com.example.rene.steppenwolf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class erzaehltechnik extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;

    ExpandableListAdapter adapter;
    ExpandableListView expListView;
    ArrayList<String> headlines;
    HashMap<String, List<String>> childs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erzaehltechnik);

        setToolbar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        expListView = (ExpandableListView) findViewById(R.id.list_view);
        prepare();

        adapter = new ExpandableListAdapter(getApplicationContext(), headlines, childs);

        expListView.setAdapter(adapter);
    }

    private void prepareListData(){

        headlines = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.erzaehltechnik_headlines)));
        childs = new HashMap<>();

        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("alkvnalsknl kansvlknas lkvn alksnvl anlkvn alksvnlaknl vaskn " +
                "lkasnvlknbldsknvk jsavskjn kdjb kasb s" +
                "ak sjvnkasjnvkjbkcj bsakjvn kyjbvk jysbkj bvkjybkjvbkjSbvkj BSKJbvk jBKJS bv" +
                "SkjvbKJSBv kjbsKJvbkjbKJ vkjBKJb kjVKJbKJBK VjbKSJbvkjBKjbkjBKvjbsKj bkjBSkvj bKSJv" +
                "Kjv kjsBK jvnkSJN v" +
                "svlkn LKSn vlkn SLKNV lknlk NSLvn lskN VLnS");



        childs.put(headlines.get(0), top250); // Header, Child data
        childs.put(headlines.get(1), nowShowing);
        childs.put(headlines.get(2), comingSoon);
    }

    private void prepare(){
        headlines = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.erzaehltechnik_headlines)));
        ArrayList<String> texts  = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.erzaehltechnik_texts)));

        childs = new HashMap<>();


        if(texts.size() == headlines.size()){
            for(int i = 0; i < texts.size(); i++){
                childs.put(headlines.get(i), new ArrayList<>(Arrays.asList(texts.get(i))));
            }
        }else{
            Toast.makeText(getApplicationContext(), "Dimensions do not match.", Toast.LENGTH_LONG).show();
        }
    }

    private void setToolbar(){
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Erzähltechnik");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_18dp);
        toolbar.setId(R.id.toolbar);
    }
}
