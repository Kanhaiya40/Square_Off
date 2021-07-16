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
import com.alibi.squareoff.model.PortraitData;
import com.bumptech.glide.Glide;

import java.util.List;

public class PortraitViewAdapter extends RecyclerView.Adapter<PortraitViewAdapter.ViewHolder> {

    List<PortraitData> transResponseDataList;
    Context context;

    public PortraitViewAdapter(List<PortraitData> transResponseList, Context context) {
        this.transResponseDataList = transResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.portrait_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortraitViewAdapter.ViewHolder holder, int position) {
        PortraitData transResponseData = transResponseDataList.get(position);
        holder.name.setText(transResponseData.getName());
        holder.slug.setText(transResponseData.getSlug());
        holder.year.setText(transResponseData.getYear());
        holder.noOfDashInSlug.setText(transResponseData.getNoOfDashCharacter());
        Glide.with(context)
                .load(transResponseData.getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return transResponseDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView slug;
        TextView year;
        TextView noOfDashInSlug;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            slug = itemView.findViewById(R.id.slug);
            year = itemView.findViewById(R.id.year);
            noOfDashInSlug = itemView.findViewById(R.id.dashCharacter);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
