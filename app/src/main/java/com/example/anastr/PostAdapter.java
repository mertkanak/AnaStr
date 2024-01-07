package com.example.anastr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import okhttp3.Response;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

        private Context context;
        private List<Photos> photosList;

        public PostAdapter(Context context, List<Photos> photosList) {
            this.context = context;
            this.photosList = photosList;
        }

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
            return new PostViewHolder(view);
        }


    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Photos photos = photosList.get(position);
        holder.textView.setText(photos.getTitle());
        Glide.with(holder.itemView.getContext()).load(photos.getUrl()).into(holder.imageView);
    }


    @Override
        public int getItemCount() {
            return photosList.size();
        }

    public void setPhotosList(List<Photos> photosList) {
        this.photosList = photosList;
    }



    public class PostViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;

            public PostViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.image_view);
                textView = itemView.findViewById(R.id.text_view);


            }
        }
}
