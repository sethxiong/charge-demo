package com.seth.charge.demo;

public class Iphone extends Phone {
    private final Type type = Type.IPHONE;

    public Iphone() {
    }

    @Override
    protected Type getType() {
        return type;
    }
}
