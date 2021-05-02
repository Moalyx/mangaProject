package com.tuto.mangaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerView extends AppCompatActivity {

    RecyclerView myRecyclerView;
    List<Manga> mangaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view);

        myRecyclerView = findViewById(R.id.myRecyclerView);


        String[] imageUrl = getResources().getStringArray(R.array.image_manga_url);
        String[] title = getResources().getStringArray(R.array.title);
        String[] description = getResources().getStringArray(R.array.description);

        Manga kingdom = new Manga(imageUrl[0], title[0], description[0]);
        Manga soloLeveling = new Manga(imageUrl[1], title[1], description[1]);
        Manga theBreaker = new Manga(imageUrl[2], title[2], description[2]);
        Manga berserk = new Manga(imageUrl[3], title[3], description[3]);
        Manga thePromisedNeverlan = new Manga(imageUrl[4], title[4], description[4]);
        Manga onePunchMan = new Manga(imageUrl[5], title[5], description[5]);
        Manga deathNote = new Manga(imageUrl[6], title[6], description[6]);
        Manga ibitsu = new Manga(imageUrl[7], title[7], description[7]);
        Manga hellsing = new Manga(imageUrl[8], title[8], description[8]);
        Manga gto = new Manga(imageUrl[9], title[9], description[9]);

        mangaList.add(kingdom);
        mangaList.add(soloLeveling);
        mangaList.add(theBreaker);
        mangaList.add(berserk);
        mangaList.add(thePromisedNeverlan);
        mangaList.add(onePunchMan);
        mangaList.add(deathNote);
        mangaList.add(ibitsu);
        mangaList.add(hellsing);
        mangaList.add(gto);

        MyAdapter myAdapter =new MyAdapter(this,mangaList);
        myRecyclerView.setAdapter(myAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));




    }
}