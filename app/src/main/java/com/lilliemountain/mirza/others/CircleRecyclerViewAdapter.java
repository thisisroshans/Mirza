package com.lilliemountain.mirza.others;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lilliemountain.mirza.R;

import java.util.List;

public class CircleRecyclerViewAdapter extends RecyclerView.Adapter<CircleRecyclerViewAdapter.CircleRecyclerHolder> {
    private int lastPosition = -1;
    private Context context;
    List<CircleRecycler> list;
    public CircleRecyclerViewAdapter(Context context, List<CircleRecycler> list)
    {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public CircleRecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_open_circle,viewGroup,false);
        return new CircleRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CircleRecyclerHolder circleRecyclerHolder, int i) {
        circleRecyclerHolder.con.setBackgroundColor(list.get(i).getColor());
        circleRecyclerHolder.t.setText(list.get(i).getTitle());
        circleRecyclerHolder.s.setText(list.get(i).getSubtitle());
        circleRecyclerHolder.iv.setBackgroundResource(list.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CircleRecyclerHolder extends RecyclerView.ViewHolder {
        ConstraintLayout con;
        TextView t,s;
        ImageView iv;
        public CircleRecyclerHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            con=itemView.findViewById(R.id.con);
            t=itemView.findViewById(R.id.t);
            s=itemView.findViewById(R.id.s);
        }
    }
}
