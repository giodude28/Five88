package io.giodude.five88.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

import io.giodude.five88.Adapter.EventAdapter;
import io.giodude.five88.Model.EventModel;
import io.giodude.five88.R;
import io.giodude.five88.ViewModel.EventViewModel;

public class EventFive extends Fragment {
    private EventViewModel eventViewModel;
    private List<EventModel.PreviousEvents> eventsModel = new ArrayList<>();
    public EventAdapter eventAdapter;
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager rLayout;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_event_five, container, false);
        showevents();
        return view;
    }

    private void getEvents(List<EventModel.PreviousEvents> eventModels){
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_up_to_down);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        rLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayout);
        eventAdapter = new EventAdapter(getContext(), eventModels);
        recyclerView.setAdapter(eventAdapter);
    }

    private void showevents(){
        eventViewModel = ViewModelProviders.of(EventFive.this).get(EventViewModel.class);
        eventViewModel.init();

        eventViewModel.getEvents().observe(this, events ->{
            getEvents(events);
            eventsModel.addAll(events);
            eventAdapter.notifyDataSetChanged();
        });
    }

}