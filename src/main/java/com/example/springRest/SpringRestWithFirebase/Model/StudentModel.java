package com.example.springRest.SpringRestWithFirebase.Model;

public class StudentModel {
    private int sID;
    private String name;
    private String town;
    private int age;

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "StudentModel{" +
                "sID=" + sID +
                ", name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", age=" + age +
                '}';
    }
}
