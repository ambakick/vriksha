package com.example.akash.agrotracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
    }

    public void a1(View view) {
        Intent i = new Intent(getApplicationContext(),MainActivitymap.class);
        startActivity(i);
    }

    public void a2(View view) {
        Intent i = new Intent(getApplicationContext(),MainActivitytrack.class);
        startActivity(i);
    }
}
