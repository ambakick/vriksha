package com.example.akashravi.vriksha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class view_tender extends AppCompatActivity implements GreenAdapter.ListItemClickListener
 {
    DatabaseReference dbr2;
    public ArrayList<tender_add> tenderlist;
    private GreenAdapter mAdapter;
    private RecyclerView mNumbersList;
    private Toast mToast;
    //boolean mutex;

     protected void recy()
     {
         System.out.println("After firebase->>"+tenderlist.size());
         mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);
         LinearLayoutManager layoutManager = new LinearLayoutManager(this);
         mNumbersList.setLayoutManager(layoutManager);

         mNumbersList.setHasFixedSize(true);
         System.out.println("After firebase 2\n"+tenderlist.size());
         // while (mutex!=true);
         //if(mutex==true) {
         {
             mAdapter = new GreenAdapter(tenderlist.size(), this, tenderlist);
             //mAdapter=new GreenAdapter(this);
             mNumbersList.setAdapter(mAdapter);
         }

         System.out.println("After Adapter 3"+tenderlist.size());

     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tender);
       // mutex=false;
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbr2 = db.getReference("Tender");
        tenderlist = new ArrayList<>();
        System.out.println("bpppp 1");
        dbr2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("bpppp 2");
                tenderlist.clear();
                int k = 0;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    tender_add tend = postSnapshot.getValue(tender_add.class);
                    tend.id = k;
                    tenderlist.add(tend);
                    System.out.println("bpppp 3");

                    System.out.println("Hello" + tenderlist.get(k).pname.toString());
                    System.out.println("Hello" + tenderlist.get(k).ph.toString());
                    System.out.println("Hello" + tenderlist.get(k).addr.toString());
                    k++;
                }
                System.out.println("bpppp= " + tenderlist.size());
                recy();
                //mutex=true;
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tender_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId) {

            case R.id.action_refresh:
                // COMPLETED (14) Pass in this as the ListItemClickListener to the GreenAdapter constructor
                mAdapter = new GreenAdapter(tenderlist.size(), this,tenderlist);
                mNumbersList.setAdapter(mAdapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // COMPLETED (10) Override ListItemClickListener's onListItemClick method

    @Override
    public void onListItemClick(int clickedItemIndex) {

        if (mToast != null) {
            mToast.cancel();
        }

        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }
    }

