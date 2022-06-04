package com.seth.charge.demo;

public class Charger implements Chargeable {
    private ChargingLine chargingLine;
    private boolean status;

    public Charger() {
    }

    public Charger(ChargingLine chargingLine) {
        this.chargingLine = chargingLine;
    }

    public void setChargingCable(ChargingLine chargingLine) {
        this.chargingLine = chargingLine;
    }

    @Override
    public void charge(Phone phone) {
        if (chargingLine.getType().equals(phone.getType())) {
            phone.setCharging(true);
            this.status = true;
        } else {
            phone.setCharging(false);
            this.status = false;
        }
    }

    public Type getChargingPhoneType() {
        return chargingLine.getType();
    }

    @Override
    public boolean getStatus() {
        return status;
    }
}


class ChargingLine {
    private final Type type;

    public ChargingLine(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}

enum Type {
    IPHONE("苹果"),
    ANDROID("安卓"),
    ;
    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}