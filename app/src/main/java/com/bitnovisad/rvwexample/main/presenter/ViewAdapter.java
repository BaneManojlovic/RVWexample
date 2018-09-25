package com.bitnovisad.rvwexample.main.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bitnovisad.rvwexample.R;
import com.bitnovisad.rvwexample.main.model.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.bitnovisad.rvwexample.R.layout.custom_row;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    //data for players
    List<Player> data = Collections.emptyList();

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Player current = data.get(position);
        holder.pictPlayer.setImageResource(current.playerImage);
        holder.namePlayer.setText(current.playerName);
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
