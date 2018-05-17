package com.example.akashravi.vriksha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class add_storage extends AppCompatActivity {

    private WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_storage);
        browser = (WebView) findViewById(R.id.browser);
        browser.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSemSq0syMa0-Gb4qwXWJBPYq4gSUZ4wJNPV1KXWyV4Cxx3X8A/viewform?usp=sf_link");
    }
}
