package com.limu.review.$static;

public class BananaFactory implements FoodFactory{
    @Override
    public Food get() {
        return new Banana();
    }
}
