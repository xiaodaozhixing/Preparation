package com.example.auspicious.preparation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.*;
import com.example.auspicious.preparation.Adapters.AdapterForListViewInMain;
import com.example.auspicious.preparation.Views.EmptyView;

public class Main extends AppCompatActivity {
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
                new String[]{"1", "2"});
        listView.setAdapter(adapter);
    }
    private void findView(){
        textViewTitle = findViewById(R.id.text_view_title);
        emptyView = findViewById(R.id.empty_view);
        listView = findViewById(R.id.list_view);
    }
}
