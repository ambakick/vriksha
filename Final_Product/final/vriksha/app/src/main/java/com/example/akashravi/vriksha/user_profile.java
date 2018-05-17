package com.example.akashravi.vriksha;

public class user_profile {

    String id;
    int kycbool;
    String notification;
    //int a,b,c,d;
    String email;
    String name;

    public user_profile()
    {

    }

    public user_profile(String id, int kycbool, String a, String b)
    {
        this.id=id;
        this.kycbool=kycbool;
        this.notification="No notifications yet.\n Check again later";
        this.name=a;
        this.email=b;
    }

}


