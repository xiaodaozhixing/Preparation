package com.example.auspicious.preparation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.auspicious.preparation.Adapters.AdapterForListViewInMain;
import com.example.auspicious.preparation.Views.EmptyView;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView textViewTitle;
    private EmptyView emptyView;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        findView();
        textViewTitle.setText(Html.fromHtml(
            "原来<br/>" +
                    "<font color='red'>设置TextView的文字，<br/></font>"+
                    "<font color='black'>还可以用Html！</font>",0)
        );
        listView.setEmptyView(emptyView);

        AdapterForListViewInMain adapter = new AdapterForListViewInMain(this, R.layout.layout_main_list_view, R.id.text_view,
                new String[]{"0", "1"});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    private void findView(){
        textViewTitle = findViewById(R.id.text_view_title);
        emptyView = findViewById(R.id.empty_view);
        listView = findViewById(R.id.list_view);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.v("ListView Clicked", position + "");
        switch (position){
            case 0:
                Intent intentCamera = new Intent(Main.this, Camera.class);
                this.startActivity(intentCamera);
                break;
            case 1:
                Intent intentRecyclerView = new Intent(Main.this, RecyclerViewStudy.class);
                this.startActivity(intentRecyclerView);
                break;
            default:
                break;
        }
    }
}
