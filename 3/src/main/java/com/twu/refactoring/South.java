package com.imooc.lambda.cart;

public class South extends Direction {
    public static Direction direction = new South('s');

    public South(char S) {
        super(S);
    }

    public static Direction getDirection() {
        return direction;
    }

    public Direction turnRight() {
        return West.getWest();
    }

    public Direction turnLeft() {
        return East.getDirection();
    }
}
