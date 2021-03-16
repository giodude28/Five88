package io.giodude.five88.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.giodude.five88.Adapter.CardGameAdapter;
import io.giodude.five88.Data.CardGamesData;
import io.giodude.five88.Model.CardGamesModel;
import io.giodude.five88.R;

public class CardGameFive extends Fragment {
private CardGameAdapter cardGameAdapter;
private CardGamesModel cardGamesModel;
public static RecyclerView recyclerView;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_card_game_five, container, false);
        cards();
        return view;
    }

    private void cards(){
        List<CardGamesModel> cardss = new ArrayList<>();
        for (int i = 0; i < CardGamesData.gamename.length; i++){
            cardss.add(new CardGamesModel(CardGamesData.gamename[i],CardGamesData.gameimage[i],CardGamesData.gamedesc[i]));
        }
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        cardGameAdapter = new CardGameAdapter(getContext(),cardss);
        recyclerView.setAdapter(cardGameAdapter);

    }
}