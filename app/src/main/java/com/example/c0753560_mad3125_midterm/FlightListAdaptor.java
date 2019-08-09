package com.example.c0753560_mad3125_midterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.c0753560_mad3125_midterm.JavaClass.FlightMain;

import java.util.ArrayList;

public class FlightListAdaptor extends RecyclerView.Adapter<FlightListAdaptor.flightListViewHolder>
{
    private Context mContext;
    private ArrayList<FlightMain> mFlightList;

    @NonNull
    @Override
    public flightListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.flightlist, parent, false);
        return new flightListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull flightListViewHolder holder, int position) {
        FlightMain currentItem = mFlightList.get(position);


        String flightName = currentItem.getMissionName();
        String launchYear = currentItem.getLaunchYear();

        holder.mFlightName.setText(flightName);
        holder.mLaunchYear.setText(launchYear);

        Glide.with(holder.mFlightImage.getContext()).load(currentItem.getLinks().getMissionPatchSmall()).into(holder.mFlightImage);

       /* Glide.with(mContext)
                .load(imageview)
                .centerCrop()
                .placeholder(R.drawable.logo)
                .into(holder.mImageView);*/


    }

    @Override
    public int getItemCount() {
        return mFlightList.size();
    }

    public class flightListViewHolder extends RecyclerView.ViewHolder{
        public ImageView mFlightImage;
        public TextView mFlightName;
        public TextView mLaunchYear;

        public flightListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mFlightImage = mFlightImage;
            this.mFlightName = mFlightName;
            this.mLaunchYear = mLaunchYear;
        }
    }

}
