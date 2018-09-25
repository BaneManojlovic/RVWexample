package com.bitnovisad.rvwexample.main.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bitnovisad.rvwexample.R;
import com.bitnovisad.rvwexample.main.model.Player;
import com.bitnovisad.rvwexample.main.view.PlayerDetailsFragment;

import java.util.Collections;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> implements IntViewAdapter {

    private ViewAdapter vAdapter;
    private LayoutInflater inflater;
    //data for players
    List<Player> data = Collections.emptyList();

//    public ViewAdapter(ViewAdapter vAdapter) {
//        this.vAdapter = vAdapter;
//    }

    //step 6.
    public ViewAdapter(Context context, List<Player> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflater.inflate(R.layout.custom_row, parent.false);
        View view = inflater.inflate(R.layout.custom_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    //this method fill items with data
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final Player current = data.get(position);
        holder.pictPlayer.setImageResource(current.playerImage);
        holder.namePlayer.setText(current.playerName);

        //handlig click events on player image
        holder.pictPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Opening details for " + position, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    //ne znam sta je ovo???
    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView pictPlayer;
        TextView namePlayer;

        public MyViewHolder(View itemView) {
            super(itemView);
            pictPlayer = itemView.findViewById(R.id.playerImage);
            namePlayer = itemView.findViewById(R.id.playerName);
        }
    }
}
