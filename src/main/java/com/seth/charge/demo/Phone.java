package com.seth.charge.demo;


import java.util.Objects;

public abstract class Phone {
    protected boolean charging;

    public Phone() {
    }

    protected abstract Type getType();

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public boolean isCharging() {
        return charging;
    }

    public void setCharging(boolean charging) {
        this.charging = charging;
    }

    @Override
    public String toString() {
        return  Integer.toHexString(hashCode())
                + "@Phone{" +
                "name=" + getName() + ",\t" +
                "type=" + getType() + ",\t" +
                "charging=" + charging +
                '}';
    }

}

