package com.limu.review.$static;


public class Test {
    public static void main(String[] args) {
        FoodFactory apple = new AppleFactory();
        Food food1 = apple.get();
        food1.get();

        FoodFactory banana = new BananaFactory();
        Food food2 = banana.get();
        food2.get();
    }
}
