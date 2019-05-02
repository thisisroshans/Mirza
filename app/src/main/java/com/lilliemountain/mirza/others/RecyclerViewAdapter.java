package com.lilliemountain.mirza.others;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.lilliemountain.mirza.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerHolder> {
    private int lastPosition = -1;
    private Context context;
    public RecyclerViewAdapter(Context context)
    {
        this.context=context;
    }
    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview,viewGroup,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder recyclerHolder, int i) {
        setAnimation(recyclerHolder.itemView,i);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerHolder holder) {
        ((RecyclerHolder)holder).clearAnimation();

    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        View RootLayout;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            RootLayout= itemView;

        }
        public void clearAnimation()
        {
            RootLayout.clearAnimation();
        }
    }
}
