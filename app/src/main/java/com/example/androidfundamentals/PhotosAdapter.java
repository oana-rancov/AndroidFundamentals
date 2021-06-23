package com.example.androidfundamentals;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>{
    private static final String TAG = PhotosAdapter.class.getSimpleName();
    private List<String> photoList;

    //constructor -> trebuie sa primeasca lista lui de stirngs
    PhotosAdapter(List<String> photoList){
        this.photoList = photoList;
    }


    /*
    createView face inflate, adica creeaza fiecare item pentru recyclerView
    face inflate la fiecare item in lista
     */
    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutInflater ne ajuta sa ne definim view-ul
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerView = layoutInflater.inflate(R.layout.item_photo, parent, false );

        return new PhotosViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.PhotosViewHolder holder, int position) {
        // seteaza informatia pe view
        // seteaza datele pe item-ul respectiv, functioneaza ca un for
        // adica pt fieacre item din lista se apeleaza si se seteaza datele
        String photo = photoList.get(position);
        holder.photo.setText(photo);
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "POSITION CLICK: text= " + photo + " position " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        //returneaza count-ul listei in cazul nostru 6 elemente
        //daca vrem de ex la elem 10 sa adaugam altceva
        return photoList.size();
    }
    //ViewHolder -> tine datele despre un item din lista

    static class PhotosViewHolder extends RecyclerView.ViewHolder {
        //define info from our item
        TextView photo;

        //primeste un view care e recyclerView din onCreateViewHolder()
        public PhotosViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo); //avem acces la informatia din item
        }
    }
}
