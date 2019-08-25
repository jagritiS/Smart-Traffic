package jask.smarttraffic.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.dynamic.IFragmentWrapper;

import java.util.ArrayList;
import java.util.List;

import jask.smarttraffic.com.api.ApiService;
import jask.smarttraffic.com.api.RetrofitHelper;
import jask.smarttraffic.com.model.ParkingResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParkingsActivity extends AppCompatActivity {
    private ApiService apiService;
    private RecyclerView recyclerView;
    private List<ParkingResponse> parkingResponseList = new ArrayList<>();
    private ParkingAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkings);
        apiService = RetrofitHelper.getInstance().getAuthService();
        recyclerView = findViewById(R.id.recyclerView);
        initRecycler();
        getData();
    }

    private void initRecycler() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ParkingAdapter(this, parkingResponseList);
        recyclerView.setAdapter(adapter);

    }

    public static boolean isNetworkAvailable(Context mContext) {
        boolean result = false;
        try {
            ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        result = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }


    private void getData() {
        if (isNetworkAvailable(this)) {
            Call<List<ParkingResponse>> call = apiService.getParking();
            call.enqueue(new Callback<List<ParkingResponse>>() {
                @Override
                public void onResponse(Call<List<ParkingResponse>> call, Response<List<ParkingResponse>> response) {
                    if (response.code() == 200) {
                        List<ParkingResponse> list = response.body();
                        if (list != null && list.size() > 0) {
                            parkingResponseList.clear();
                            parkingResponseList.addAll(list);
                            adapter.notifyDataSetChanged();
                        }
                        Log.d("ResponseData", String.valueOf(response.body()));

                    } else {
                        Log.d("Errorresponse", "data success fail");
                    }
                }

                @Override
                public void onFailure(Call<List<ParkingResponse>> call, Throwable t) {
                    Log.d("Errorresponse", t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(this, "No network available", Toast.LENGTH_LONG).show();
        }
    }

}
