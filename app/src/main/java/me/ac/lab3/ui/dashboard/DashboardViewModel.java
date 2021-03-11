package me.ac.lab3.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This app shows a list of countries, along with their capitals and regions.\n If you want to learn more about a country, simply tap on the country's row.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}