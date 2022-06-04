package com.seth.charge.demo;

public class Android extends Phone {
    private final Type type = Type.ANDROID;

    public Android() {
    }

    @Override
    protected Type getType() {
        return type;
    }
}
