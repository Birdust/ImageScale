package com.example.imagescale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyImageView myView = new MyImageView(this);
        setContentView(myView);
        setContentView(R.layout.activity_main);
    }
}