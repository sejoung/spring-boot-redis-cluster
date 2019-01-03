package com.github.sejoung.util;

import org.springframework.stereotype.Component;

@Component
public class RandomUtil {

    public int randomRange() {
        return this.randomRange(1,6);
    }

    private int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }
}
