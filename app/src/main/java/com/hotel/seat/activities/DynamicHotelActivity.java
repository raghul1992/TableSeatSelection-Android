package com.hotel.seat.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.hotel.seat.R;
import com.hotel.seat.adapters.TableAdapter;
import com.hotel.seat.dynamic_modal.SeatModal;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DynamicHotelActivity extends AppCompatActivity {

    LinkedHashMap<String, ArrayList<SeatModal>> hashMapTable;
    ArrayList<SeatModal> arrayListSeat;

    private RecyclerView rvTables;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_hotel);
        context = this;
        initUI();
        prepareData();
    }


    void prepareData(){
        hashMapTable = new LinkedHashMap<>();
        hashMapTable.put("" + 1, getSeat(6));
        hashMapTable.put("" + 2, getSeat(10));
        hashMapTable.put("" + 3, getSeat(8));
        hashMapTable.put("" + 4, getSeat(2));
        hashMapTable.put("" + 5, getSeat(2));
        hashMapTable.put("" + 6, getSeat(4));
        hashMapTable.put("" + 7, getSeat(6));
        hashMapTable.put("" + 8, getSeat(10));

        TableAdapter mTableAdapter = new TableAdapter(context, hashMapTable);
        rvTables.setAdapter(mTableAdapter);

    }


    ArrayList<SeatModal>  getSeat(int no){
        arrayListSeat=new ArrayList<>();

        for(int i = 0; i<no;i++){
            int j = i+1;
            arrayListSeat.add(new SeatModal("" + j, false));
        }

        return arrayListSeat;

    }



    private void initUI() {
        rvTables =  findViewById(R.id.recycle_tables_dynamic);

        rvTables.setLayoutManager(new StaggeredGridLayoutManager( 2,1));

    }


}




















