package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Main_Rv extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

     final static int ONE = 1;
     final static int TWO = 2;

    @Override
    public int getItemViewType(int position) {
        //多布局
        if (position == 0){
            return ONE;
        }else if (position == 5){
            return TWO;
        }else {
            return 0;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == ONE){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.titleber, viewGroup, false);
             return new MyHolder(inflate);
        }else if (i == TWO){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.titleber, viewGroup, false);
        return   new MyHolder(inflate);
        }else{
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
            return new MyHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {

        return 100;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
