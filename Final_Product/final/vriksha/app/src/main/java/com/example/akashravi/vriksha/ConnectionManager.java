package com.example.akashravi.vriksha;

/**
 * Created by akash on 10-09-17.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class ConnectionManager {

    private Context context;

    public ConnectionManager(Context context){
        this.context = context;
    }
    public boolean isConnectingToInternet(){

        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = cm.getAllNetworkInfo();
        if (info != null){
            for (int i = 0; i < info.length; i++){
                if (info[i].getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
