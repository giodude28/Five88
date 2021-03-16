package io.giodude.five88.Connection;

import io.giodude.five88.Model.EventModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("eventspastleague.php?id=4328")
    Call<EventModel> getEvents();
}
