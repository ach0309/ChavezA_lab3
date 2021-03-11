package me.ac.lab3.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import javax.net.ssl.SSLSession;

import me.ac.lab3.model.Country;

public class CountriesViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ArrayList<Country> countryList;

    public CountriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is countries fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


//    public MutableLiveData<ArrayList<Country>> getCountryList() {
//        return countryList;
//    }

//    public void addCountryList(ArrayList<Country> myCountryList){
//        countryList.postValue(myCountryList);
//    }
//}
}