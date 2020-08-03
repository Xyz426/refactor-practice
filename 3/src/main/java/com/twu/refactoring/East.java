package com.imooc.lambda.cart;

public class East extends Direction {
    public static Direction direction = new East('E');

    public East(char direction) {
        super(direction);
    }

    public static Direction getDirection() {
        return direction;
    }

    public Direction turnRight() {
        return null;
    }

    public Direction turnLeft() {
        return null;
    }
}
