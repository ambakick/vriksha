package com.example.akashravi.vriksha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@IgnoreExtraProperties
class seller_add {

    public String name;
    public String loc;
    public int rt;
    public int qt;
    public String uid;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public seller_add() {
    }

    public seller_add(String name, String loc, int rt, int qt, String uid) {
        this.name = name;
        this.loc = loc;
        this.rt=rt;
        this.qt=qt;
        this.uid=uid;
    }
}

public class seller_ip extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String s="";
    DatabaseReference dbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_ip);
        final Button insert=(Button)findViewById(R.id.button12);
        ///////////////////////////////////////////

        NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("Select Crops", "Husked Coconut", "Tender Coconut", "Cotton Bale", "Non Absorbant Cotton Roll"
                ,"Onion","Carrot","Apple","Atta","Maize","Raw Jute","Chana Dal","Green Peas","Basmati Rice","Brown Rice"));
        niceSpinner.attachDataSource(dataset);
        niceSpinner.setHeight(300);
        niceSpinner.setOnItemSelectedListener(this);


        ///////////////////////////////////////////
        insert.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                Toast.makeText(seller_ip.this,"Submitted",Toast.LENGTH_SHORT).show();
                insert.setBackgroundColor(getResources().getColor(R.color.common_google_signin_btn_text_light));
                EditText text ;
                String name = s;
                text = (EditText) findViewById(R.id.editText12);
                String loc = text.getText().toString();
                text = (EditText) findViewById(R.id.editText13);
                String rt = text.getText().toString();
                int Rt=Integer.parseInt(rt);

                //String json="{'Trader Name': " + name + "'Location': "+ loc +", 'Rate':" + rt +", 'Number of vehicles':" + vno + "}";
                text = (EditText) findViewById(R.id.editText14);
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

                seller_add ob = new seller_add(name,loc,Rt,Qt,user.getUid());

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                dbr = db.getReference("Seller");

                dbr.push().setValue(ob);
                // dbr.child(name).setValue(ob);


            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        s = (String) parent.getItemAtPosition(pos).toString();
        //s = parent.getSelectedItem().toString();
        //s=parent.getItemAtPosition(parent.getSelectedItemPosition()).toString();
        System.out.println("ssssss="+s);
        if(id==3)
            System.out.println("sssssskp");

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
