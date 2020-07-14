package com.rajumia.photoframe.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajumia.photoframe.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {

    int[] images;
    RecyclerView recyclerView;

    public class MyView extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.displayPic);
        }
    }

    public RecyclerViewAdapter(int[] horizontalList,RecyclerView recyclerView){
        this.recyclerView = recyclerView;
        this.images = horizontalList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);

        //new improvement
        int width = recyclerView.getWidth();
        ViewGroup.LayoutParams params = itemView.getLayoutParams();
        params.width = (int)(width);
        itemView.setLayoutParams(params);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
