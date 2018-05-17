package com.example.akashravi.vriksha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class view_notifications extends AppCompatActivity {

    DatabaseReference dbr2;
    String p;
   // List<user_profile> userProfileList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notifications);
        final TextView sample = (TextView)findViewById(R.id.notif_display);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbr2 = db.getReference("User_ac");
        //userProfileList = new ArrayList<>();
        //System.out.println("bp 1");
        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        p = currentUser.getUid();
        dbr2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // System.out.println("bp 2");
               // userProfileList.clear();
                //int k=0;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    user_profile user = postSnapshot.getValue(user_profile.class);
                   // tend.id=k;
                   // userProfileList.add(tend);
                    //System.out.println("bp 3");
                    if(p.equalsIgnoreCase(user.id))
                        sample.setText((CharSequence) user.notification);
                }
                // System.out.println("bp " + tenderlist.size());
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

    }
}
