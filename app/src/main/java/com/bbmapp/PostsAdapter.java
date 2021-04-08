package com.bbmapp;
import android.content.Context;
import android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post1> posts;
    private View view;

    public PostsAdapter(Context context, List<Post1> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        Post1 post1 = posts.get(position);
        holder.bind(post1);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvBusiness;
        private ImageView ivImage;
        private TextView tvLocation;
        private TextView tvCategory;
        private TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBusiness = itemView.findViewById(R.id.tvBusiness);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvDescription = itemView.findViewById(R.id.tvDescription);


        }

        public void bind(Post1 post1) {
            tvBusiness.setText(post1.getBusiness());
            tvLocation.setText(post1.getLocation());
            tvCategory.setText(post1.getCategory());
            tvDescription.setText(post1.getDescription());
            ParseFile image = post1.getImage();
            if (image != null) {
                Glide.with(context).load(post1.getImage().getUrl()).into(ivImage);


            }
        }
    }
}
