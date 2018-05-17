package com.example.akashravi.vriksha;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties


public class tender_req extends AppCompatActivity {
    DatabaseReference dbr1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_req);
        Button insert=(Button)findViewById(R.id.tend_sbt);

        insert.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.tend_cname);
                String name = text.getText().toString();
                text = (EditText) findViewById(R.id.tend_adr);
                String loc = text.getText().toString();

                text = (EditText) findViewById(R.id.tend_ph);
                String ph = text.getText().toString();

                //String json="{'Trader Name': " + name + "'Location': "+ loc +", 'Rate':" + rt +", 'Number of vehicles':" + vno + "}";
                text = (EditText) findViewById(R.id.tend_dr);
                String dr = text.getText().toString();
                int Dr = 0;
                try
                {
                    Dr=Integer.parseInt(dr);
                }
                catch (NumberFormatException e)
                {
                    // handle the exception
                }
                text = (EditText) findViewById(R.id.tend_qt);
                String qt = text.getText().toString();
                int Qt = 0;
                try
                {
                    Qt=Integer.parseInt(qt);
                }
                catch (NumberFormatException e)
                {
                    // handle the exception
                }

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                tender_add ob = new tender_add(name,loc,ph,Qt,Dr,user.getUid());

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                dbr1 = db.getReference("Tender");

                dbr1.push().setValue(ob);
                // dbr.child(name).setValue(ob);


            }
        });
    }

}
