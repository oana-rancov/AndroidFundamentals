package com.example.androidfundamentals;

import java.io.Serializable;

class Person5 implements Serializable {
    String name;
    String age;

    Person5(String name, String age){
        this.name = name;
        this.age = age;
    }

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
