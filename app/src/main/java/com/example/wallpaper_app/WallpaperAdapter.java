package com.example.wallpaper_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.wallpaperViewHolder> {

    private ArrayList<String> list;
    private Context context;

    public WallpaperAdapter(ArrayList<String> list,Context context)
    {
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public wallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_image_layout,parent,false);


        return new wallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wallpaperViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,FullimageActivity.class);
                intent.putExtra("image",list.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class wallpaperViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public wallpaperViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
        }
    }
}
