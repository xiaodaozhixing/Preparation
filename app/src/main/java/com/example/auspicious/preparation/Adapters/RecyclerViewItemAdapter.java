package com.example.auspicious.preparation.Adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.auspicious.preparation.R;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class RecyclerViewItemAdapter extends RecyclerView.Adapter<RecyclerViewItemAdapter.ItemHolder> {
    private interface OnItemClickListener{
        void onItemClick(ItemHolder itemHolder, int position);
    }
    private ArrayList<String> pictureNames;
    private ArrayList<String> picturePaths;
    private OnItemClickListener onItemClickListener;
    private LayoutInflater layoutInflater;

    public RecyclerViewItemAdapter(Context context){
        Log.v("Into function", "RecyclerViewItemAdapter");
        pictureNames = new ArrayList<>();
        picturePaths = new ArrayList<>();

        this.layoutInflater = LayoutInflater.from(context);

        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if(cursor==null || cursor.getCount() <= 0){
            Log.i("Cursor", "No Picture Found");
        }
        else {
            while (cursor.moveToNext()){
                int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                String path = cursor.getString(index);
                File file = new File(path);
                if(file.exists()){
                    pictureNames.add(path);
                    picturePaths.add(path);
                }
            }
        }
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.v("Into function", "onCreateViewHolder");
        View itemView = layoutInflater.inflate(R.layout.layout_recycler_view_study_item, viewGroup, false);
        return new RecyclerViewItemAdapter.ItemHolder(itemView, this);
    }
    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        Log.v("Into function", "onBindViewHolder");
        Log.v("pictureName" ,itemHolder.getPictureName().toString());
        itemHolder.textViewName.setText(this.pictureNames.get(i));
        itemHolder.imageViewPicture.setImageURI(Uri.fromFile(new File(this.picturePaths.get(i))));
    }

    @Override
    public int getItemCount() {
        Log.v("Into function", "getItemCount");
        return this.pictureNames.size();
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RecyclerViewItemAdapter classParent;
        private TextView textViewName;
        private ImageView imageViewPicture;

        public ItemHolder(View itemView, RecyclerViewItemAdapter classParent){
            super(itemView);
            this.classParent = classParent;
            textViewName = itemView.findViewById(R.id.text_view_picture_name);
            imageViewPicture = itemView.findViewById(R.id.image_view_picture);
        }

        public CharSequence getPictureName(){
            return textViewName.getText();
        }

        @Override
        public void onClick(View v) {
            final OnItemClickListener listener = classParent.getOnItemClickListener();
            if (listener != null) {
                listener.onItemClick(this, getLayoutPosition());
            }
        }
    }
}
