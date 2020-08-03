package com.imooc.lambda.cart;

public class North extends Direction {
    public static Direction direction = new North('N');


    public static Direction getDirection() {
        return direction;
    }

    public North(char direction) {
        super(direction);
    }

    public Direction turnRight() {
        return East.getDirection();
    }

    public Direction turnLeft() {
        return West.getWest();
    }
}
