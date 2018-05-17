package com.example.akashravi.vriksha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.*;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Buyer_menu extends AppCompatActivity implements OnItemSelectedListener {

    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_menu);

/*        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Catagories, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
       // Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);*/
        NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("Select Crop Type", "Fruits and Vegetables", "Cotton", "Rice", "Pulses","Grain","Jute","Coconut"));
        niceSpinner.attachDataSource(dataset);
        niceSpinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        if(pos>=1) {
            s = (String) parent.getItemAtPosition(pos - 1).toString();
            //s = parent.getSelectedItem().toString();
            //s=parent.getItemAtPosition(parent.getSelectedItemPosition()).toString();
            System.out.println("ssssss=" + s);
            if (id == 3)
                System.out.println("sssssskp");
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void tend_ip(View view) {
        Intent intent= new Intent(getApplicationContext(),tender_req.class);
        startActivity(intent);
    }

    public void getweburl(View view) {
        if(s.length()>0)
        {
            System.out.println("ssssss2="+s);
            Intent i = new Intent(this, Buyer_web.class);
            i.putExtra("catstr", s);
            startActivity(i);
        }
        else
            System.out.println("ssssssfff");
    }
}
