package io.giodude.five88.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.five88.Connection.Repositories;
import io.giodude.five88.Model.EventModel;

public class EventViewModel extends ViewModel {

    private MutableLiveData<List<EventModel.PreviousEvents>> events;
    public Repositories repositories;

    public void init(){
        if (events != null){
            return;
        }
        repositories = Repositories.getInstance();
        events = repositories.getEvents();
    }
    public LiveData<List<EventModel.PreviousEvents>> getEvents(){
        return events;
    }
}
