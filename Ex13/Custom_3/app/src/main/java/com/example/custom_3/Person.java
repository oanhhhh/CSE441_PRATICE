package com.example.custom_3;

public class Person {
    String id;
    String name;
    String numberphone;

    public Person(String id, String name, String numberphone) {
        this.id = id;
        this.name = name;
        this.numberphone = numberphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }
}
