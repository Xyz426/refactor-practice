package com.imooc.lambda.cart;

public class West extends Direction {
    public static Direction west = new West('w');

    public static Direction getWest() {
        return west;
    }

    public West(char w) {
        super(w);
    }

    public Direction turnRight() {
        return South.getDirection();
    }

    public Direction turnLeft() {
        return South.getDirection();
    }
}
