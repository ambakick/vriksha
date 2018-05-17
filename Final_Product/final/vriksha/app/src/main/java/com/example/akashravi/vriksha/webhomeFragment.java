package com.example.akashravi.vriksha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class webhomeFragment extends Fragment {


    public webhomeFragment() {
        // Required empty public constructor
    }

    public WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homewv, container, false);
        mWebView = (WebView) v.findViewById(R.id.homewv);

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebChromeClient(new WebChromeClient() {


            public void onProgressChanged(WebView view, int progress) {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                //super.setTitle("Loading...");
                //setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
               // if (progress == 100)
                    //setTitle(R.string.app_name);
            }


        });
        mWebView.loadUrl("https://techtocore.github.io/test2.html");
        return v;

    }
}
