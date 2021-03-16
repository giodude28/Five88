package io.giodude.five88.Connection;


import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.giodude.five88.Model.EventModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {


    private static Repositories instance;
    static ApiClient rfit = new ApiClient();
    public static Repositories getInstance(){
        if (instance==null) {
            instance = new Repositories();
        }
        return instance;
    }

    public MutableLiveData<List<EventModel.PreviousEvents>> getEvents(){

        final MutableLiveData<List<EventModel.PreviousEvents>> data = new MutableLiveData<>();
        Call<EventModel> call = rfit.retrofitBuilder().getEvents();
        call.enqueue(new Callback<EventModel>() {
            @Override
            public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                EventModel dataList1 = response.body();
                List<EventModel.PreviousEvents> samples = dataList1.getPrevious();
                data.setValue(samples);
            }

            @Override
            public void onFailure(Call<EventModel> call, Throwable t) {

            }
        });
        return data;
    }

//    public MutableLiveData<List<Event.Events>> getEvents(){
//        final MutableLiveData<List<Event.Events>> data = new MutableLiveData<>();
//        Call<List<Event.Events>> call = rfit.retrofitBuilder().getEvents();
//        call.enqueue(new Callback<List<Event.Events>>() {
//            @Override
//            public void onResponse(Call<List<Event.Events>> call, Response<List<Event.Events>> response) {
//                List<Event.Events> dataList1 = response.body();
//                data.setValue(dataList1);
//            }
//
//            @Override
//            public void onFailure(Call<List<Event.Events>> call, Throwable t) {
//
//            }
//        });
//        return data;
//    }
}
