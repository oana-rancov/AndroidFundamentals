package com.example.androidfundamentals.week9;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class PersonDao {

    @Query("SELECT * FROM Person")
    public abstract List<PersonEntity> getAllPersons();

    @Transaction
    public void insertPersons(List<PersonEntity> personList){
        deleteAll(); //face si delete pt ca altfel ar fi tot bagat persoanele
        insertThePersons(personList);
    }

    @Insert
    public abstract void insertThePersons(List<PersonEntity> personEntityList);

    @Insert
    public abstract void insertPerson(PersonEntity person);

    @Query("DELETE FROM Person")
    public abstract void deleteAll();

    @Update
    public abstract void updatePersons(List<PersonEntity> personEntityList);

    @Delete
    public abstract void delete(PersonEntity person);
}
