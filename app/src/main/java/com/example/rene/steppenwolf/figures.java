package com.example.rene.steppenwolf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class figures extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;

    ExpandableListAdapter adapter;
    ExpandableListView expListView;

    // OBSOLETE
    ArrayList<String> headlines;
    HashMap<String, List<String>> childs;
    // --------

    List<String> Headlines;
    Map<String, List<String>> SecondLevel;
    Map<String, List<String>> ThirdLevel;

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
        //prepare();

        prepare_three_lvls();

        //adapter = new ExpandableListAdapter(getApplicationContext(), headlines, childs);
        ParentLevelAdapter m_adapter = new ParentLevelAdapter(getApplicationContext(), this.Headlines, this.SecondLevel, this.ThirdLevel);
        expListView.setAdapter(m_adapter);
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

    private void prepare_three_lvls() {

        List<String> listDataHeader = new ArrayList<>();
        String[] mItemHeaders = getResources().getStringArray(R.array.figures_names);
        Collections.addAll(listDataHeader, mItemHeaders);
        this.Headlines = listDataHeader;

        // Init second level data
        Map mListData_SecondLevel_Map = new HashMap<>();
        int parentCount = listDataHeader.size();
        for (int i = 0; i < parentCount; i++) {
            String content = listDataHeader.get(i);
            switch (content) {
                case "Maria":
                    mItemHeaders = getResources().getStringArray(R.array.figures_maria_details);
                    break;
                case "Level 1.2":
                    //mItemHeaders = mContext.getResources().getStringArray(R.array.items_array_expandable_level_one_two_child);
                    break;
                default:

                    break;
            }
            mListData_SecondLevel_Map.put(listDataHeader.get(i), Arrays.asList(mItemHeaders));
        }
        this.SecondLevel = mListData_SecondLevel_Map;

        // THIRD LEVEL
        String[] mItemChildOfChild;
        List<String> listChild;
        Map<String, List<String>> mListData_ThirdLevel_Map = new HashMap<>();
        for (Object o : mListData_SecondLevel_Map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Object object = entry.getValue();
            if (object instanceof List) {
                List<String> stringList = new ArrayList<>();
                Collections.addAll(stringList, (String[]) ((List) object).toArray());
                for (int i = 0; i < stringList.size(); i++) {
                    mItemChildOfChild = getResources().getStringArray(R.array.maria_first_appearance);
                    listChild = Arrays.asList(mItemChildOfChild);
                    mListData_ThirdLevel_Map.put(stringList.get(i), listChild);
                }
            }
        }

        this.ThirdLevel = mListData_ThirdLevel_Map;
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Figuren");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_18dp);
        toolbar.setId(R.id.toolbar);
    }
}
