package com.example.akashravi.vriksha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import com.example.akash.agri.CsvReader.java;
//import com.opencsv.*;
import java.io.*;
import java.lang.String;


public class find_crop extends AppCompatActivity {

    private EditText mnth1,yar1;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_crop);



        mnth1 = (EditText) findViewById(R.id.findmon);
        yar1 = (EditText) findViewById(R.id.findyr);

        b1 = (Button) findViewById(R.id.fndbtn);

        b1.setOnClickListener(  new View.OnClickListener(){
            @Override
            public void onClick(View v1) {

                /*
                CSVReader reader = null;
                try {
                    reader = new CSVReader(new FileReader("Result.csv"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String nextLine = "";
                */
                InputStreamReader is = null;
                try {
                    is = new InputStreamReader(getAssets().open("What_to_grow.csv"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                BufferedReader reader = new BufferedReader(is);
                try {
                    reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String nextLine;
                try {
                    while ((nextLine = reader.readLine()) != null) {
                        // nextLine[] is an array of values from the line
                        // System.out.println(nextLine[0] + nextLine[1] + "etc...");
                        String[] tokens = nextLine.split(",");

                        String mt = mnth1.getText().toString();
                        String ye = yar1.getText().toString();


                        if(tokens[0].equalsIgnoreCase(mt) && tokens[1].equalsIgnoreCase(ye) )
                        {
                            TextView res = (TextView)findViewById(R.id.showprdt);
                            res.setText("Estimated Crop to grow:  "  + tokens[2] );
                            break;

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });




    }

}
