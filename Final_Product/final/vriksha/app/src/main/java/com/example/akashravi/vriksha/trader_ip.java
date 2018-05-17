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
class Logistic {

    public String name;
    public String loc;
    public int vno;
    public int rt;
    public int qt;
    public String uid;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Logistic() {
    }

    public Logistic(String name, String loc, int rt, int vno, int qt, String uid) {
        this.name = name;
        this.loc = loc;
        this.rt=rt;
        this.vno=vno;
        this.qt=qt;
        this.uid=uid;
    }
}

public class trader_ip extends AppCompatActivity{
    DatabaseReference dbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trader_ip);
        Button insert=(Button)findViewById(R.id.button2);

        insert.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.editText);
                String name = text.getText().toString();
                text = (EditText) findViewById(R.id.editText2);
                String loc = text.getText().toString();
                text = (EditText) findViewById(R.id.editText3);
                String rt = text.getText().toString();
                int Rt=Integer.parseInt(rt);
                text = (EditText) findViewById(R.id.editText4);
                String vno = text.getText().toString();
                int Vno = 0;
                try
                {
                    Vno=Integer.parseInt(vno);
                }
                catch (NumberFormatException e)
                {
                    // handle the exception
                }

                //String json="{'Trader Name': " + name + "'Location': "+ loc +", 'Rate':" + rt +", 'Number of vehicles':" + vno + "}";
                text = (EditText) findViewById(R.id.editText5);
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

                Logistic ob = new Logistic(name,loc,Rt,Vno,Qt,user.getUid());

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                dbr = db.getReference("Traders");

                dbr.push().setValue(ob);
               // dbr.child(name).setValue(ob);


            }
        });

        //dbr.child("Traders").push().setValue(json);
    }

}
