package com.example.auspicious.preparation.Adapters;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.auspicious.preparation.R;

public class AdapterForListViewInMain extends ArrayAdapter<String> {

    public AdapterForListViewInMain(Context context, int layout, int resId, String[] itms){
        super(context, layout, resId, itms);
    }

    public AdapterForListViewInMain(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.layout_main_list_view, parent, false);
        }
        ImageView imageView = row.findViewById(R.id.image_view);
        TextView textView = row.findViewById(R.id.text_view);
        switch (position){
            case 0:
                imageView.setImageResource(R.mipmap.camera);
                textView.setText(getContext().getString(R.string.camera));
                break;
            case 1:
                imageView.setImageResource(R.mipmap.recycler_view);
                textView.setText(getContext().getString(R.string.recycler_view));
                break;
            default:
                break;
        }
        return row;
    }
}
