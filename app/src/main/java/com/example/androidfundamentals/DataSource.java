package com.example.androidfundamentals;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    class Person {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    public List<String> getPhotoList(){
        List<String> photos = new ArrayList();
        photos.add("Photos1");
        photos.add("Photos2");
        photos.add("Photos3");
        photos.add("Photos4");
        photos.add("Photos5");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");

        return photos;
    }

    public List<Person> getPersons(){
        Person person = new Person();
        person.setName("Oana");
        person.setAge("21");

        Person person2 = new Person();
        person2.setName("Tae");
        person2.setAge("25");

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        return personList;
    }
}
