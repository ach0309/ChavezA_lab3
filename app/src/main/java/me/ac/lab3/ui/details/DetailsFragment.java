package me.ac.lab3.ui.details;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import me.ac.lab3.R;
import me.ac.lab3.controller.DetailsRecyclerView;
import me.ac.lab3.model.Country;

public class DetailsFragment extends Fragment {
    private RecyclerView detailsRecyclerView;
    private DetailsViewModel mViewModel;
    private RecyclerView.Adapter adapter;
    private ArrayList<Country> countryList;
    private RequestQueue requestQueue;
    private Country country;

 //   private Button doneButton;



    @Override
    public void onCreate(Bundle myBundle) {
        super.onCreate(myBundle);
        countryList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getContext());

        }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details, container, false);
        mViewModel =new ViewModelProvider(this).get(DetailsViewModel.class);
       // adapter = new DetailsRecyclerView(R.layout.detailsview_layout, countryList);


        Bundle bundle = getArguments();
        int position = bundle.getInt("card", -1);
        final TextView textView_nameCountry = root.findViewById(R.id.textView_countryName);
        final TextView textView_region = root.findViewById(R.id.textView_capitalAns);
        final TextView textView_capital = root.findViewById(R.id.textView_regionAns);

        String nameBundle = bundle.getString("name");
        String regionBundle = bundle.getString("region");
        String capitalBundle = bundle.getString("capital");

        textView_nameCountry.setText(nameBundle);
        textView_region.setText(regionBundle);
        textView_capital.setText(capitalBundle);


        final TextView textView_language = root.findViewById(R.id.textView_langAns);
        final TextView textView_population = root.findViewById(R.id.textView_popAns);
        final TextView textView_currency = root.findViewById(R.id.textView_curAns);
        final TextView textView_timezone = root.findViewById(R.id.textView_timeAns);

        String languageBundle = bundle.getString("language");
        String populationBundle = bundle.getString("population");
        String currencyBundle = bundle.getString("currency");
        String timezoneBundle = bundle.getString("timezone");

        textView_language.setText(languageBundle);
        textView_population.setText(populationBundle);
        textView_currency.setText(currencyBundle);
        textView_timezone.setText(timezoneBundle);


        Log.i("position", String.valueOf(position));
        Log.i("name", String.valueOf(nameBundle));
        Log.i("region", String.valueOf(regionBundle));
        Log.i("capital", String.valueOf(capitalBundle));
        Log.i("population", String.valueOf(populationBundle));
        Log.i("language", String.valueOf(languageBundle));
        Log.i("currency", String.valueOf(currencyBundle));




        return root;
    }


}
