package com.pro.mylistpokemon;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterModelDetails extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<ListPokemonDetails> Arrayproduit = new ArrayList<ListPokemonDetails>();
    String url;
    ImageView img;

    public AdapterModelDetails(Activity MA, ArrayList<ListPokemonDetails > arrayproduit) {
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
            view1=layoutInflater.inflate(R.layout.detailspokemon,null);
        }

        TextView ability = view1.findViewById(R.id.ability);
        ability.setText(Arrayproduit.get(i).getAbility());

        TextView slot = view1.findViewById(R.id.slot);
        slot.setText(Arrayproduit.get(i).getSlot());

        TextView is_hidden = view1.findViewById(R.id.is_hidden);
        is_hidden.setText(Arrayproduit.get(i).getIshidden());


        return  view1;
    }
}
