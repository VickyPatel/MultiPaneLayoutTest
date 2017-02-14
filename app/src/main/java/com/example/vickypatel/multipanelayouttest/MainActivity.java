package com.example.vickypatel.multipanelayouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerViewAdapter = new RecyclerViewAdapter(
                this,
                new ArrayList<>(Arrays.asList("Xyz", "Abc", "Pqr")),
                mTwoPane);

        mRecyclerView.setAdapter(mRecyclerViewAdapter);


    }
}
