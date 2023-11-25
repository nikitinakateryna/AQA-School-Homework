package org.example;

import com.github.javafaker.Faker;

public class Homework1 {
    public static void main(String[] args) {
        System.out.println(Faker.instance().animal().name());
    }
}
