package com.example.auspicious.preparation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecyclerViewStudy extends AppCompatActivity {

    private TextView textViewEmpty;
    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearManager;
    private LinearLayoutManager verticalLinearManager;
    private GridLayoutManager horizontalGridManager;
    private GridLayoutManager verticalGridManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view_study);

    }
    private void initViews(){
        textViewEmpty = findViewById(R.id.text_view_empty);
        recyclerView = findViewById(R.id.recycler_view);

        horizontalLinearManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        verticalLinearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        horizontalGridManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        horizontalGridManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
    }
}
