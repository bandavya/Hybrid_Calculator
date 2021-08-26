package com.example.hybridcalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SharedViewModel extends androidx.lifecycle.ViewModel {
private MutableLiveData<Integer> data = new MutableLiveData<>();
   public void setData(Integer ans){
       data.setValue(ans);

   }
   public LiveData<Integer> getdata(){
       return data;
   }

}
