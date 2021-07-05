package com.example.androidfundamentals;

import android.util.Log;

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



    class Student{
        private String FirstName;
        private String LastName;

        public Student(String FirstName, String LastName){
            this.FirstName = FirstName;
            this.LastName = LastName;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }
    }

    public List<Student> getStudents(){

        List<Student> studentList = new ArrayList<>();
        /*
         Student student1 = new Student();
         student1.setFirstName("FirstName 1");
         student1.setLastName("LastName 1");

        Student student2 = new Student();
        student2.setFirstName("FirstName 2");
        student2.setLastName("LastName 2");

        studentList.add(student1);
        studentList.add(student2); */

        /*
        Student[] student = new Student[10];
        for(int i = 0; i < 10; i++) {
            student[i] = new Student("FirstName " + i, "LastName " + i);
            studentList.add(student[i]);
        } */


        for(int i = 0; i < 10; i++) {
            int j = i+1;
            studentList.add(new Student("FirstName " + j, "LastName " + j));
        }

        return studentList;
    }
}
