package me.ac.lab3.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import me.ac.lab3.R;
//import me.ac.lab3.controller.GetData;
import me.ac.lab3.controller.ItemRecyclerView;
import me.ac.lab3.model.Country;

public class CountriesFragment extends Fragment {

//    private MutableLiveData<ArrayList<Country>> countryList;
    private ArrayList<Country> countryList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private RequestQueue requestQueue;
    private CountriesViewModel countriesViewModel;
//    private GetData getData;

    @Override
    public void onCreate(Bundle myBundle){
        super.onCreate(myBundle);
//        countryList = new MutableLiveData<ArrayList<Country>>();
        countryList = new ArrayList<Country>();
        countriesViewModel =
                new ViewModelProvider(this).get(CountriesViewModel.class);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        requestQueue =Volley.newRequestQueue(getContext());
        adapter = new ItemRecyclerView(R.layout.cardview_layout, countryList);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

//        getData = new GetData(recyclerView, adapter, requestQueue, this);
//        getData.parseJSON();
//        adapter.notifyDataSetChanged();

        parseJSON();
        return root;



    }

    private void parseJSON(){
        String url ="https://restcountries.eu/rest/v1/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject jsonData = array.getJSONObject(i);

                            String countryName = jsonData.getString("name");
                            String capitalName = jsonData.getString("capital");
                            String regionName = jsonData.getString("region");

                            String population = jsonData.getString("population");
                            String currencies = jsonData.getString("currencies");
                            String languages = jsonData.getString("languages");
                            String timezones = jsonData.getString("timezones");


                            Country country =new Country(countryName, capitalName, regionName, currencies,languages,timezones,population);
                            countryList.add(country);
                        }
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(stringRequest);

    }



}