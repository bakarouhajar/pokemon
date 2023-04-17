package com.pro.mylistpokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ListPokemon>  list = new ArrayList<>();
    ListView listView;
    Button btn_previous,btn_next;
    String nextUrl,previousUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_previous=findViewById(R.id.btn_previous);
        btn_next=findViewById(R.id.btn_next);
        listView =findViewById(R.id.listpokemon);
        String url ="https://pokeapi.co/api/v2/pokemon/";
        CallListPokemon(url);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url =nextUrl;
                CallListPokemon(url);

            }
        });

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url =previousUrl;
                CallListPokemon(url);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent (MainActivity.this, MainActivity2.class);
                intent.putExtra("url", list.get(i).getUrl());
                intent.putExtra("image", list.get(i).getImage());
                startActivity(intent);

            }
        });


    }

    private void CallListPokemon(String url){
        list.clear();
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                    try {

                        String next = response.getString("next");
                        String previous = response.getString("previous");
                        Log.d("next",next);
                        Log.d("previous",previous);

                        if(next!=null){
                            nextUrl=next;
                        }
                        if(previous!=null){
                            previousUrl=previous;
                        }


                        JSONArray jsonArray = response.getJSONArray("results");

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject test = jsonArray.getJSONObject(i);
                            String name= test.getString("name");
                            String url= test.getString("url");
                            String[] id = url.split("/");
                            String urlImage= "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id[6]+".png";
                            list.add(new ListPokemon(name,url,urlImage));

                        }

                        AdapterModel ad = new AdapterModel(MainActivity.this,list);
                        listView.setAdapter(ad);

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