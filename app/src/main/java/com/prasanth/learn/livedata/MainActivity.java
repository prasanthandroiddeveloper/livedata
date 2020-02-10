package com.prasanth.learn.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Toolbar toolbar;
    FloatingActionButton fab;
    MainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         tv=findViewById(R.id.tvNumber);
         fab = findViewById(R.id.fab);

         model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
         LiveData<String> myRandomNumber = model.getNumber();
         myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv.setText(s);
            }
        });
    }}

