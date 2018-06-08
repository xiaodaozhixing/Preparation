package com.example.auspicious.preparation.ForCamera;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewItemAdapter extends RecyclerView.Adapter<RecyclerViewItemAdapter.ItemHolder> {
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RecyclerViewItemAdapter classParent;
        private TextView titleView, summaryView;

        public ItemHolder(View itemView, RecyclerViewItemAdapter classParent){
            super(itemView);
            this.classParent = classParent;

        }

        @Override
        public void onClick(View v) {

        }
    }
}
