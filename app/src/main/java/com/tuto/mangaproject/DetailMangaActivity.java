package com.tuto.mangaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMangaActivity extends AppCompatActivity {

    TextView titleDet;
    ImageView imageDet;
    TextView descriptionDet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_manga);

        titleDet = findViewById(R.id.title_detail);
        imageDet = findViewById(R.id.image_detail);
        descriptionDet = findViewById(R.id.description_detail);
        getIncomingIntent();


    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("manga")) ;
        Manga manga = getIntent().getParcelableExtra("manga");
        setImage(manga.getImage());
        setTitle(manga.getTitle());
        setDescription(manga.getDescription());
    }


    private void setImage(String image) {
        Glide.with(this)
                .load(image)
                .into(imageDet);
    }
    private  void  setTitle(String titleDetail ){
        titleDet.setText(titleDetail);

    }

    private void setDescription(String description){
        descriptionDet.setText(description);

    }

}