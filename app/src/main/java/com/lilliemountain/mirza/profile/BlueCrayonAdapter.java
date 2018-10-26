package com.lilliemountain.mirza.profile;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lilliemountain.mirza.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

public class BlueCrayonAdapter extends RecyclerView.Adapter<BlueCrayonAdapter.BlueCrayonHolder> {

    List<Integer> list;
    public BlueCrayonAdapter(    List<Integer> list) {
        this.list=list;
    }
    @NonNull
    @Override
    public BlueCrayonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.blue_crayon_gallery,viewGroup,false);
        return new BlueCrayonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlueCrayonHolder blueCrayonHolder, int i) {
        Picasso.get().load(list.get(i)).into(blueCrayonHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BlueCrayonHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BlueCrayonHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.post_image);
        }
    }
}
