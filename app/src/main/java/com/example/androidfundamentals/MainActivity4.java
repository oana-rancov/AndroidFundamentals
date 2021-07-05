package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    //item_photo, DataSource, PhotosAdapter, activity_main4.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //define data source dor recyclerview
        DataSource dataSource = new DataSource();
        List<String> photoList = dataSource.getPhotoList();

        //alt data source de obiect Person
        List<DataSource.Person> personList = dataSource.getPersons();

        //get recycler in mainActivity and define a linearLayout manager
        //LinearLayout Manager defines how the items from recycler should be ordered (horizontal/vertical)
        RecyclerView photoListRecycler = findViewById(R.id.photoList);

        //definelayoutManager for recycler
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        photoListRecycler.setLayoutManager(linearLayoutManager);

        //now the last step: create the Adapter
        //define photo list
        PhotosAdapter photosAdapter = new PhotosAdapter(photoList, personList);
        photoListRecycler.setAdapter(photosAdapter);
    }
}