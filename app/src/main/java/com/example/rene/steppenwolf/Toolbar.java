package com.example.rene.steppenwolf;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by rene on 29.09.17.
 */

public class Toolbar {
    private android.support.v7.widget.Toolbar toolbar;

    Toolbar(final AppCompatActivity parent, String title){


    }

    public void setOnClickListener(View.OnClickListener listener){
        toolbar.setNavigationOnClickListener(listener);
    }
}
