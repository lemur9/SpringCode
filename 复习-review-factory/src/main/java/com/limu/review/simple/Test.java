package com.limu.review.simple;

public class Test {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Food food = simpleFactory.get("apple");
        food.get();
        food = simpleFactory.get("banana");
        food.get();
    }
}
