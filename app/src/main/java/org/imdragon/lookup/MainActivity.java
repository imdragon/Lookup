package org.imdragon.lookup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Place> places;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.cardsList);
//        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        setup();
        setAdapter();

    }

    private void setup() {
        places = new ArrayList<>();
        places.add(new Place("Santa Barbara Beach", "beach, awesome, romantic", R.drawable.sbbeach));
        places.add(new Place("SB Courthouse", "downtown, historic, tourist", R.drawable.courthouse));
        places.add(new Place("Tunnel Trail", "hiking, healthy, photos", R.drawable.tunneltrail));
    }

    private void setAdapter (){
        RAdapter mAdapter = new RAdapter(places);
        mRecyclerView.setAdapter(mAdapter);
    }
}

