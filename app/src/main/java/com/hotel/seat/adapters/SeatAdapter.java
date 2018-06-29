package com.hotel.seat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.hotel.seat.R;
import com.hotel.seat.dynamic_modal.SeatModal;
import com.hotel.seat.utils.OnItemClickListener;

import java.util.ArrayList;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.CustomViewHolder> {
    ArrayList<SeatModal> arrayListSeat;
    private Context mContext;


    public SeatAdapter(Context context,   ArrayList<SeatModal> arrayListSeat) {
        this.arrayListSeat = arrayListSeat;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_seat, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder,final int i) {
        final SeatModal item = arrayListSeat.get(i);
        customViewHolder.cb_seat.setChecked(item.isBoolSeatStatus());
        customViewHolder.cb_seat_name.setText(item.getStrSeatNumber());

        if((i+1)>getItemCount()/2)customViewHolder.dividereview.setVisibility(View.GONE);

        customViewHolder.cb_seat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arrayListSeat.get(i).setBoolSeatStatus(isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayListSeat ? arrayListSeat.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        CheckBox cb_seat;
        TextView cb_seat_name;
        View dividereview;

        CustomViewHolder(View view) {
            super(view);
            this.cb_seat = view.findViewById(R.id.cb_seat);
            this.cb_seat_name = view.findViewById(R.id.cb_seat_name);
            this.dividereview = view.findViewById(R.id.dividereview);
        }
    }



}