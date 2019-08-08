package com.example.c0753560_mad3125_midterm.Activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FlightListAdaptor extends RecyclerView
{

    public class flightListViewHolder extends RecyclerView.ViewHolder{
        public ImageView mFlightImage;
        public TextView mFlightName;
        public TextView mLaunchYear;

        public flightListViewHolder(@NonNull View itemView, ImageView mFlightImage, TextView mFlightName, TextView mLaunchYear) {
            super(itemView);
            this.mFlightImage = mFlightImage;
            this.mFlightName = mFlightName;
            this.mLaunchYear = mLaunchYear;
        }
    }

}
