package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SharedPrefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        TextView tv = (TextView) findViewById(R.id.tvEmail);
        Intent intent = getIntent();

        String i = intent.getStringExtra("keyEmail");
        tv.setText(i.toString());
    }
}
