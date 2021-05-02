package com.tuto.mangaproject;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.aware.IdentityChangedListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Manga> mangaList;
    Context context;

    public MyAdapter(Context context, List<Manga> mangaList) {
        this.context = context;
        this.mangaList = mangaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.one_line_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Manga manga = mangaList.get(position);
        holder.title.setText(manga.getTitle());
//        holder.description.setText(manga.getDescription());

        Glide.with(context)
                .load(manga.getImage())
                .centerCrop()
                .circleCrop()
                .into(holder.imageManga);

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mangaList.remove(manga);
                notifyItemRemoved(position);
            }
        });

        holder.imageManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMangaActivity.class);
                intent.putExtra("manga",manga);
                context.startActivity(intent);


            }


        });




    }


    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageManga;
        TextView title;
        Button deleteButton;
        TextView description;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageManga = itemView.findViewById(R.id.imageManga);
            title = itemView.findViewById(R.id.manga_title);
            deleteButton = itemView.findViewById(R.id.deleteButton);

//            description = itemView.findViewById(R.id.manga_description);

        }


    }
}
