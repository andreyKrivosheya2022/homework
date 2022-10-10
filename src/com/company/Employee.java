package com.company;

public class Employee {
    //Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, возраст.
   private String full_name,post,email, number_phone;
   private int age;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String full_name, String post, String email, String number_phone, int age) {
        this.full_name = full_name;
        this.post = post;
        this.email = email;
        this.number_phone = number_phone;
        this.age = age;
    }
}
