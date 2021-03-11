package me.ac.lab3.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.ac.lab3.model.Country;
import me.ac.lab3.model.ViewHolder;

public class ItemRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Country> countryList;
    private int layout_id;

    public ItemRecyclerView(int id, ArrayList<Country> countryList){
        this.layout_id = id;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_id, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView name = ((ViewHolder) holder).name;
        TextView capital = ((ViewHolder) holder).capital;
        TextView region = ((ViewHolder) holder).region;

        name.setText(countryList.get(position).name);
        capital.setText(countryList.get(position).capital);
        region.setText(countryList.get(position).region);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}


