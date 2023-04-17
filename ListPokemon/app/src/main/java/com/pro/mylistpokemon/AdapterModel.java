package com.pro.mylistpokemon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterModel extends BaseAdapter {



    LayoutInflater layoutInflater;
    ArrayList<ListPokemon> Arrayproduit = new ArrayList<ListPokemon>();
    String url;
    ImageView img;

    public AdapterModel(MainActivity MA, ArrayList<ListPokemon > arrayproduit) {
        this.layoutInflater = MA.getLayoutInflater();
        this.Arrayproduit = arrayproduit;

    }


    @Override
    public int getCount() {
        return Arrayproduit.size();
    }

    @Override
    public Object getItem(int i) {
        return Arrayproduit.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View  view1 = view;

        if(view1==null)
        {
            view1=layoutInflater.inflate(R.layout.listpokemon,null);
        }

        TextView txt_Name = view1.findViewById(R.id.txt_name);
        txt_Name.setText(Arrayproduit.get(i).getName());

        url = Arrayproduit.get(i).getImage();
        img = view1.findViewById(R.id.img);
        Glide.with(view1).load(url).into(img);

        return  view1;
    }
}
