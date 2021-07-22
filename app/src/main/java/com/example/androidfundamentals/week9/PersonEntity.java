package com.example.androidfundamentals.week9;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Person")
public class PersonEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "surname")
    public String surname;

    @ColumnInfo(name = "homeAddress")
    public String homeAddress;

    public PersonEntity(String name,
                        String surname,
                        String homeAddress){
        this.name = name;
        this.surname = surname;
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString(){
        return "PersonEntity{" +
                "id=" + id +
                " name ='" + name + '\'' +
                " surname ='" + surname + '\'' +
                " homeAddress'" + homeAddress + '\'' +
                '}';
    }

}
