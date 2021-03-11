package me.ac.lab3.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.ac.lab3.model.Country;
import me.ac.lab3.model.ViewHolder;

public class DetailsRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private ArrayList<Country> countryList;
    private int layout_id;

    public DetailsRecyclerView(int id, ArrayList<Country> countryList){
        this.layout_id = id;
        this.countryList=countryList;
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
        TextView currencies = ((ViewHolder) holder).currencies;
        TextView languages = ((ViewHolder) holder).languages;
        TextView timezones = ((ViewHolder) holder).timezones;
        TextView population = ((ViewHolder) holder).population;


        name.setText(countryList.get(position).name);
        capital.setText(countryList.get(position).capital);
        region.setText(countryList.get(position).region);
        currencies.setText(countryList.get(position).currencies);
        languages.setText(countryList.get(position).languages);
        timezones.setText(countryList.get(position).timezones);
        population.setText(countryList.get(position).population);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}