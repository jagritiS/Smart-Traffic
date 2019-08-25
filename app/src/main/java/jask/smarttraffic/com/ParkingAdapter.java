package jask.smarttraffic.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jask.smarttraffic.com.model.ParkingResponse;


public class ParkingAdapter extends RecyclerView.Adapter<ParkingVH> {
    private Context context;
    private List<ParkingResponse> parkingResponseList = new ArrayList<>();

    public ParkingAdapter(Context context, List<ParkingResponse> parkingResponseList) {
        this.context = context;
        this.parkingResponseList = parkingResponseList;
    }

    @Override
    public ParkingVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpater_parking, parent, false);
        return new ParkingVH(view);
    }

    @Override
    public void onBindViewHolder(final ParkingVH holder, final int position) {
        ParkingResponse response = parkingResponseList.get(position);
        holder.btnSpace.setText("Space " + position);
        if (response.getStat())
            holder.btnSpace.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorAvailable));
        else
            holder.btnSpace.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorUnavailable));
    }


    @Override
    public int getItemCount() {
        return parkingResponseList.size();
    }
}
