package com.example.androidfundamentals.week9;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoomActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static final String TAG = RoomActivity.class.getSimpleName();
    private static Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        com.example.androidfundamentals.week9.PersonApi api = getRetrofit().create(PersonApi.class);
        Call<List<com.example.androidfundamentals.week9.Person>> persons = api.getPersons("test_json2");

        persons.enqueue(new Callback<List<com.example.androidfundamentals.week9.Person>>() {
            @Override
            public void onResponse(Call<List<com.example.androidfundamentals.week9.Person>> call, final Response<List<com.example.androidfundamentals.week9.Person>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", response.body().toString());


                    //vrem sa adaugam persoanele din test_json2 intr-o baza de date
                    //nu putem opera de pe main thread, asa ca ne trebuie un alt thread
                    new Thread() {
                        @Override
                        public void run() {

                            //tabela, persoanele care sunt de fapt tabelele
                            ArrayList<PersonEntity> personEntities = new ArrayList<>();

                            //luam datele de pe serves si le salvam local
                            for (Person person : response.body()) {

                                personEntities.add(new PersonEntity(
                                        person.getName(),
                                        person.getSurname(),
                                        person.getHomeAddress(),
                                        "nickName" //for migration
                                ));
                            }

                            for (PersonEntity personEntity : personEntities) {
                                Database.getDatabase(RoomActivity.this).personDao().insertPerson(personEntity);
                            }

                            //insert persons de lsta mea de persoane
                            Database.getDatabase(RoomActivity.this).personDao().insertPersons(personEntities);
                            //Database.getDatabase(RoomActivity.this).personDao().insertPerson(new PersonEntity("Oana", "Rancov", "Timisoara"));
                        }
                    }.start();


                } else {

                    Log.d("Response", "Response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.w("Response", "Error in call", t);
            }
        });

        //cand apasam pe buton, iau din baza de date
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        List<PersonEntity> personEntities = Database
                                .getDatabase(RoomActivity.this)
                                .personDao()
                                .getAllPersons();


                        //Cand apasam pe buton, ne vin persoanele pe care le-am adaugat
                        Log.d("Persons", "The persons are " + personEntities.toString());
                        //for migration
                        String currentDBPath = getDatabasePath("my_database.db").getAbsolutePath();

                        Log.d(TAG, currentDBPath);
                    }
                }.start();

            }
        });
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}