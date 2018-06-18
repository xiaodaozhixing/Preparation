package com.example.auspicious.preparation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.auspicious.preparation.Adapters.RecyclerViewItemAdapter;

public class RecyclerViewStudy extends AppCompatActivity {

    private TextView textViewEmpty;
    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearManager;
    private LinearLayoutManager verticalLinearManager;
    private GridLayoutManager horizontalGridManager;
    private GridLayoutManager verticalGridManager;

    private static final int READ_EXTERNAL_STORAGE_CODE = 10000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Into function", "onCreate");
        initLayoutManagers();
        setContentView(R.layout.layout_recycler_view_study);
        initViews();

        requestPermissions();
    }
    private void initLayoutManagers(){
        Log.v("Into function", "initLayoutManagers");
        horizontalLinearManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        verticalLinearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        horizontalGridManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        horizontalGridManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
    }
    private void initViews(){
        Log.v("Into function", "initViews");
        textViewEmpty = findViewById(R.id.text_view_empty);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(verticalLinearManager);
    }

    private void requestPermissions(){
        Log.v("Into function", "requestPermissions");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.v("Into function", "onRequestPermissionsResult");
        boolean isAllGranted = true;
        if(requestCode == READ_EXTERNAL_STORAGE_CODE){
            Log.v("Passed request judge", requestCode + "");
            for (int res : grantResults){
                if(res != PackageManager.PERMISSION_GRANTED){
                    Log.v("permission not passed", res + "");
                    isAllGranted = false;
                    break;
                }
            }

            if (isAllGranted){
                Log.v("Permission request status", "true");
                /**应该在onCreate里面设置recycleView，
                 * 不过如果不取得权限，就无法在Adapter中获取设备图片
                 * **/
                recyclerView.setAdapter(new RecyclerViewItemAdapter(this));
            }
        }
    }
}
