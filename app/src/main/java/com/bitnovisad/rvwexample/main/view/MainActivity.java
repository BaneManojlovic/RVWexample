package com.bitnovisad.rvwexample.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.bitnovisad.rvwexample.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize recyclerView object
        recView = (RecyclerView) findViewById(R.id.playerRecViewList);
    }
}
