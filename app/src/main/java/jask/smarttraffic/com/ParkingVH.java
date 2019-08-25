package jask.smarttraffic.com;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class ParkingVH extends RecyclerView.ViewHolder {
    Button btnSpace;

    public ParkingVH(View itemView) {
        super(itemView);
        btnSpace = itemView.findViewById(R.id.btnSpace);
    }
}
