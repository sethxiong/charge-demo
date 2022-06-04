package com.seth.charge.demo;


public abstract class Phone {
    private boolean charging;

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
        return "Phone{" +
                "name=" + getName() + ",\t" +
                "type=" + getType() + ",\t" +
                "charging=" + charging +
                '}';
    }

}

