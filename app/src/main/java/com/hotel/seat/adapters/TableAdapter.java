package com.hotel.seat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotel.seat.R;
import com.hotel.seat.dynamic_modal.SeatModal;
import com.hotel.seat.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.CustomViewHolder> {
    LinkedHashMap<String, ArrayList<SeatModal>> hashMapTable;
    SeatAdapter mSeatAdapter;
    private Context mContext;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;

    public TableAdapter(Context context, LinkedHashMap<String, ArrayList<SeatModal>> hashMapTable) {
        this.hashMapTable = hashMapTable;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.table_item_dynamic, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        final String strTableName = (String) hashMapTable.keySet().toArray()[i];

        customViewHolder.tvSeatName.setText(strTableName);



        final ArrayList<SeatModal> arrayListSeat = new ArrayList<>();
        arrayListSeat.addAll(hashMapTable.get(strTableName));

        mSeatAdapter = new SeatAdapter(mContext, arrayListSeat);

        int span =  arrayListSeat.size() / 2;


        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager( span,1);
        customViewHolder.recycle_seats_dynamic.setLayoutManager(layoutManager);

        customViewHolder.recycle_seats_dynamic.setAdapter(mSeatAdapter);



        customViewHolder.tvSeatName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = arrayListSeat.get(0).isBoolSeatStatus();
                for(int i=0;i<arrayListSeat.size();i++){
                    arrayListSeat.get(i).setBoolSeatStatus(!flag);
                }
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != hashMapTable ? hashMapTable.size() : 0);
    }



    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvSeatName;
        protected RecyclerView recycle_seats_dynamic;

        public CustomViewHolder(View view) {
            super(view);
            this.tvSeatName = (TextView) view.findViewById(R.id.number);
            this.recycle_seats_dynamic = (RecyclerView) view.findViewById(R.id.recycle_seats_dynamic);
        }
    }
}

