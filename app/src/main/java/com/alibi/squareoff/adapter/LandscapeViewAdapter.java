package com.alibi.squareoff.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibi.squareoff.R;
import com.alibi.squareoff.model.LandScapeData;
import com.alibi.squareoff.model.TransResponseData;
import com.bumptech.glide.Glide;

import java.util.List;

public class LandscapeViewAdapter extends RecyclerView.Adapter<LandscapeViewAdapter.ViewHolder> {

    List<LandScapeData> transResponseList;
    Context context;

    public LandscapeViewAdapter(List<LandScapeData> transResponseList, Context context) {
        this.transResponseList = transResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.landscape_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandscapeViewAdapter.ViewHolder holder, int position) {
        LandScapeData transResponseData = transResponseList.get(position);
        holder.name.setText(transResponseData.getName());
        if (transResponseData.getImage() != null) {
            Glide.with(context)
                    .load(transResponseData.getImage())
                    .into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return transResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);

        }
    }
}
