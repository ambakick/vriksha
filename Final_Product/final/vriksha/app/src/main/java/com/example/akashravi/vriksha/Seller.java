package com.example.akashravi.vriksha;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Seller extends AppCompatActivity {

    /*private Button add_crop;
    private Button market_p;
    private Button track_sold;
    private Button premium;
    private Button vtend;*/

    public void add_dp(View view){
        Intent i1=new Intent(getApplicationContext(),seller_ip.class);
        startActivity(i1);
    }
    public void adv(View view){
        Intent i2=new Intent(getApplicationContext(),MarketPred.class);
        startActivity(i2);
    }
    public void find_crp(View view)
    {
        Intent i7=new Intent(getApplicationContext(),find_crop.class);
        startActivity(i7);
    }

    public void track_sld(View view){
        final String uniq="HyZq";
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Seller.this);
        View mView = getLayoutInflater().inflate(R.layout.pop_trackid, null);
        final Button submit=mView.findViewById(R.id.track_ord);
        mBuilder.setView(mView);
        final EditText track_check=(EditText) mView.findViewById(R.id.track_in);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= track_check.getText().toString();
                //System.out.println("Google:"+s);
                if(s.equals(uniq)) {
                    Toast.makeText(getApplicationContext(),"Redirecting..",Toast.LENGTH_SHORT).show();
                    Intent i5 = new Intent(getApplicationContext(), DisplayActivity.class);
                    startActivity(i5);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong code!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void prem(View view)
    {
        Intent i3=new Intent(getApplicationContext(),Premium.class);
        startActivity(i3);
    }
    public void vten(View view)
    {
        Intent i4=new Intent(getApplicationContext(),view_tender.class);
        startActivity(i4);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
       /* add_crop=(Button) findViewById(R.id.add_crop);
        market_p=(Button) findViewById(R.id.market_p);
        track_sold=(Button) findViewById(R.id.track_order);
        premium=(Button)findViewById(R.id.Premium);
        vtend=(Button)findViewById(R.id.view_tend);
*/
       /* add_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),seller_ip.class);
                startActivity(i1);
            }
        });

        market_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getApplicationContext(),MarketPred.class);
                startActivity(i2);
            }
        });

        track_sold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i3=new Intent(getApplicationContext(),)
            }
        });

        premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(getApplicationContext(),Premium.class);
                startActivity(i3);
            }
        });
        vtend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(getApplicationContext(),view_tender.class);
                startActivity(i4);
            }
        });
*/
    }
}
