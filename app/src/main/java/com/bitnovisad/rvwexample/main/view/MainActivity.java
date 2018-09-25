package com.bitnovisad.rvwexample.main.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bitnovisad.rvwexample.R;
import com.bitnovisad.rvwexample.main.model.Player;
import com.bitnovisad.rvwexample.main.presenter.ViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IntMainActivity{

    private RecyclerView recView;
    private ViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize recyclerView object - step 4.
        recView = (RecyclerView) findViewById(R.id.playerRecViewList);

        //initialize adapter
        adapter = new ViewAdapter(this, getData());

        //step 7. telling Recycler View to use Adapter
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

    }

    //method for importing data from database/xml/json file
    public static List<Player> getData(){
        List<Player> data = new ArrayList<>();

        int[] picturesPl = {R.drawable.player_picture, R.drawable.koala_pict, R.drawable.player_picture, R.drawable.koala_pict,
                            R.drawable.player_picture, R.drawable.koala_pict, R.drawable.player_picture, R.drawable.koala_pict,
                            R.drawable.player_picture, R.drawable.koala_pict, R.drawable.player_picture, R.drawable.koala_pict};
        String[] namesPl = {"Marko Markovic", "Janko Jankovic", "Ivan Ivanovic", "Nenada Nenadovic",
                            "Dimitrije Tucovic", "Vladimir Nazor", "Jovan Jovanovic", "Daniel Defo",
                            "Maksim Gorki", "Paja Jovanovic", "Ugljesa Mrnjacevic", "Marko Mrnjacevic"};

        for(int i=0; i<picturesPl.length && i<namesPl.length; i++){
            Player current = new Player();
            current.playerImage = picturesPl[i];
            current.playerName = namesPl[i];
            data.add(current);
        }
        return data;
    }


}
