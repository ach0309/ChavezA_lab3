package me.ac.lab3.model;

import org.json.JSONArray;

public class Country {
    public String name;
    public String region;
    public String capital;

    public String currencies;
    public String languages;
    public String timezones;
    public String population;


    public Country(String countryName, String capitalName, String regionName,
                   String currencies, String languages, String timezones, String population) {
        this.name = countryName;
        this.capital = capitalName;
        this.region = regionName;

        this.currencies = currencies;
        this.languages = languages;
        this.timezones = timezones;
        this.population = population;
    }



 //   public String getName(){ return name; }
//    public String getCapital(){ return capital; }
//    public String getRegion(){ return region; }




}
