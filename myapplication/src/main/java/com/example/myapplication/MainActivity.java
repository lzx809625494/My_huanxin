package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView main_Rv;
    private Main_Rv main_rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        main_Rv = (RecyclerView) findViewById(R.id.main_Rv);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
         layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){

             @Override
             public int getSpanSize(int i) {
                      if (i == 0){
                          return  3;
                      }else if (i == 5){
                          return 3;
                      }else{
                          return 1;
                      }

//                 return i == 0?3:1;
             }
         });
        main_Rv.setLayoutManager(layoutManager);
        main_rv = new Main_Rv();
        main_Rv.setAdapter(main_rv);
    }
}
