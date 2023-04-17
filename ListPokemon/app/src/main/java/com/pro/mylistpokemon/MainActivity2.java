package com.pro.mylistpokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ImageView img;
    ListView detailspokemonList;
    ArrayList<ListPokemonDetails> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img=findViewById(R.id.img_screen);
        detailspokemonList=findViewById(R.id.detailspokemon);



        Intent intent=getIntent();
        String url = intent.getStringExtra("url");
        String image = intent.getStringExtra("image");
        Log.d("url",url);
        Glide.with(MainActivity2.this).load(image).into(img);
        getDetailsPokemon(url);
    }

    private void getDetailsPokemon(String url){
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jsonArray = response.getJSONArray("abilities");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject test = jsonArray.getJSONObject(i);
                        String name=test.getJSONObject("ability").getString("name");
                        String is_hidden= test.getString("is_hidden");
                        String slot= test.getString("slot");

                        list.add(new ListPokemonDetails(name,is_hidden,slot));

                    }

                    AdapterModelDetails ad = new AdapterModelDetails(MainActivity2.this,list);
                    detailspokemonList.setAdapter(ad);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Message Volley",error.getMessage());
            }
        });

// Add the request to the RequestQueue.
        queue.add(request);
    }

}