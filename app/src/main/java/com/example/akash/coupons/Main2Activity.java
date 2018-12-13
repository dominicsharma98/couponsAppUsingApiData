package com.example.akash.coupons;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView title1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        title1=findViewById(R.id.title);


        Bundle  bundle = getIntent().getExtras();
        String url = bundle.getString("url5");
        String title2=bundle.getString("name3");
        title1.setText(title2);


        WebView myWebView = findViewById(R.id.webview);

        myWebView.loadUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

         int id = item.getItemId();

         if (id == android.R.id.home){

             finish();
             return true;
         }


        return super.onOptionsItemSelected(item);

    }
}
