package com.example.akashravi.vriksha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Storage_space extends AppCompatActivity {

    public void rec_store(View view){
        Intent intent= new Intent(getApplicationContext(),add_storage.class);
        startActivity(intent);
        System.out.println("clicked");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_space);
    }
}
