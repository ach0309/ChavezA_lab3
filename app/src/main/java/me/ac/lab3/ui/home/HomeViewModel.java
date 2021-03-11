package me.ac.lab3.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("HI THERE! \n Welcome to the Countries App :)");
    }

    public LiveData<String> getText() {
        return mText;
    }
}