package me.ac.lab3.model;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import me.ac.lab3.R;
import me.ac.lab3.ui.details.DetailsFragment;
import me.ac.lab3.ui.notifications.CountriesFragment;


public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private String TAG = "VIEW_HOLDER";

    public TextView name;
    public TextView capital;
    public TextView region;
    public TextView languages;
    public TextView timezones;
    public TextView currencies;
    public TextView population;

    private final View itemView;

    public Bundle bundle;


    public ViewHolder(View itemView) {
        super(itemView);
        this.itemView =itemView;
        itemView.setOnClickListener(this);

        name = itemView.findViewById(R.id.text_name);
        capital = itemView.findViewById(R.id.text_capital);
        region = itemView.findViewById(R.id.text_region);

        population = itemView.findViewById(R.id.det_popAns);
        languages = itemView.findViewById(R.id.det_langAns);
//        currencies = itemView.findViewById(R.id.det_curAns);
        timezones = itemView.findViewById(R.id.det_timeAns);

    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "clicked " + "item " + v.toString());
        bundle = new Bundle();
        bundle.putInt("card", getAdapterPosition());

        bundle.putString("name", name.getText().toString());
        bundle.putString("capital", capital.getText().toString());
        bundle.putString("region", region.getText().toString());
//        bundle.putString("languages", languages.getText().toString());
//        bundle.putInt("population", population.getInputType());
//        bundle.putString("currencies", currencies.getText().toString());
//        bundle.putString("timezones", timezones.getText().toString());

        Navigation.findNavController(itemView).navigate(R.id.action_navigation_notifications_to_detailsFragment, bundle);


    }
}


