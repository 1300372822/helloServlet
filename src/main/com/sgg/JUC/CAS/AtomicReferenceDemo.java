package com.sgg.JUC.CAS;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User zs = new User("zhansgan",22);
        User ls = new User("lisi",25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zs);
        atomicReference.compareAndSet(zs,ls);
        System.out.println(atomicReference.get().toString());
    }
}


class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}