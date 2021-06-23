package com.example.androidfundamentals;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>{
    private static final String TAG = PhotosAdapter.class.getSimpleName();
    private List<String> photoList;
    private List<DataSource.Person> personList;

    //constructor -> trebuie sa primeasca lista lui de strings
    PhotosAdapter(List<String> photoList, List<DataSource.Person> personList){
        this.photoList = photoList;
        this.personList = personList;
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
//        String photo = photoList.get(position);
//        String photoNr = String.valueOf(position);
//        holder.photo.setText(photo);
//        holder.photoNr.setText(photoNr);

        String name = personList.get(position).getName();
        String age = personList.get(position).getAge();
        holder.photo.setText(name);
        holder.photoNr.setText(age);

        if(position == 1) {
            holder.image.setImageResource(R.drawable.ic_launcher_foreground);
        }else{
            holder.image.setVisibility(View.GONE);
        }

        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "POSITION CLICK: text= " + photo + " position " + position);
                Log.d(TAG, "POSITION CLICK: text= " + name + " position " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        //returneaza count-ul listei in cazul nostru 6 elemente
        //daca vrem de ex la elem 10 sa adaugam altceva
        //return photoList.size();
        return personList.size(); //must return the list that we use
    }
    //ViewHolder -> tine datele despre un item din lista


    static class PhotosViewHolder extends RecyclerView.ViewHolder {
        //define info from our item
        TextView photo;
        TextView photoNr; //asta pt 2 textview din item_photo
        ImageView image;

        //primeste un view care e recyclerView din onCreateViewHolder()
        public PhotosViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo); //avem acces la informatia din item
            photoNr = itemView.findViewById(R.id.photoNr);
            image = itemView.findViewById(R.id.image);
        }
    }
}
