package com.example.akash.coupons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements MyAdapter.onItemclicklistner{

    RecyclerView recyclerView;
    List<Coupon> coups;
    String url1;
    String name1;
    String purl1;
    MyAdapter adapter;

    private static String url ="https://raw.githubusercontent.com/dominicsharma98/coupons/couponsavailable/coupons.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coups=new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        
        
        geturl();

        adapter = new MyAdapter(this ,coups);
        adapter.setonitemclicklistener(this);



    }

    private void geturl() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {

                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("coupons");

                    if(jsonArray.length() > 0) {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object1 = jsonArray.getJSONObject(i);
                            name1 = object1.getString("name");
                             url1 = object1.getString("url");
                            purl1 = object1.getString("purl");

                            coups.add(new Coupon(name1, url1,purl1));

                        }

                        recyclerView.setAdapter(adapter);


                    }
                    else {

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);



    }

    @Override
    public void onitemclick(int position) {


        Coupon coupon = coups.get(position);
        String myurl = coupon.getUrl();
        String name5 =coupon.getName();
        Intent in = new Intent(this,Main2Activity.class);
         Bundle bundle = new Bundle();
         bundle.putString("url5",myurl);
         bundle.putString("name3",name5);
         in.putExtras(bundle);
         startActivity(in);


    }
}
