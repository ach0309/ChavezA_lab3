package me.ac.lab3.controller;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.ac.lab3.model.Country;
import me.ac.lab3.ui.notifications.CountriesFragment;
import me.ac.lab3.ui.notifications.CountriesViewModel;

public class GetData {
    private MutableLiveData<ArrayList<Country>> countryList;
    private RequestQueue requestQueue;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private CountriesFragment countriesFragment;

    private CountriesViewModel countriesViewModel;

    public static ArrayList<Country> sCountryList = new ArrayList<Country>();

    public GetData(RecyclerView recyclerView, RecyclerView.Adapter adapter, RequestQueue requestQueue, CountriesFragment context){
        countriesViewModel = new ViewModelProvider(countriesFragment).get(CountriesViewModel.class);
        countryList= countriesViewModel.getCountryList();

        this.requestQueue =requestQueue;
        this.recyclerView=recyclerView;
        this.adapter=adapter;

    }

    public void parseJSON(){
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


                                String currencies = jsonData.getString("currencies");
                                String languages = jsonData.getString("languages");
                                String timezones = jsonData.getString("timezones");
                                String population = jsonData.getString("population");


                                Country country =new Country(countryName, capitalName, regionName,
                                        currencies,languages,timezones,population);
                                countriesViewModel.getCountryList().getValue().add(country);
                                sCountryList.add(country);
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