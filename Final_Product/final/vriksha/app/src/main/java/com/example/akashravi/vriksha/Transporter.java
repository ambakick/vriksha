package com.example.akashravi.vriksha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Transporter extends AppCompatActivity {

    public void on_storage(View view)
    {
        Intent intent= new Intent(getApplicationContext(),trader_ip.class);
        startActivity(intent);
        System.out.println("clicked");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter);
    }
}
