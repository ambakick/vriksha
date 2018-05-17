package com.example.akashravi.vriksha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class facil extends AppCompatActivity {

    public void ware_h(View view)
    {
        Intent i3=new Intent(getApplicationContext(),Storage_space.class);
        startActivity(i3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);
    }
}
