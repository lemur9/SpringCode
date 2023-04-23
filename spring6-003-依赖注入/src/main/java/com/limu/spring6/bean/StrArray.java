package com.limu.spring6.bean;

import java.util.Arrays;

public class StrArray {

    private String[] hobbies;

    private Woman[] womans;

    public void setWomans(Woman[] womans) {
        this.womans = womans;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "StrArray{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", womans=" + Arrays.toString(womans) +
                '}';
    }
}
