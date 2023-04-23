package com.limu.spring.review.test;

import com.limu.spring.review.simpleFactory.B;
import com.limu.spring.review.simpleFactory.StaticFactory;
import org.junit.Test;


public class SimpleFactoryTest {

    @Test
    public void testSimpleFactory() {
        B a = StaticFactory.init("b", B.class);
    }

}
