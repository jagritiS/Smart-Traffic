package jask.smarttraffic.com.api;

import java.util.List;

import jask.smarttraffic.com.model.ParkingResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {
    @GET("api")
    Call<List<ParkingResponse>> getParking();
}
