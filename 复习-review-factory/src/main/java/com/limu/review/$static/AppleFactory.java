package com.limu.review.$static;


public class AppleFactory implements FoodFactory {

    @Override
    public Food get() {
        return new Apple();
    }
}
