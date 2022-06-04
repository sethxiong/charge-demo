package com.seth.charge.demo;

public interface Chargeable {
    void charge(Phone phone);
    boolean getStatus();
    Type getChargingPhoneType();

    static void printResult(Chargeable charger, Phone phone) {
        System.out.printf("充电器状态: %-8s 充电线支持类型: %-8s  手机类型: %-8s 手机充电状态: %-8s address: @%s\n",
                charger.getStatus() ? "亮" : "熄",
                charger.getChargingPhoneType().getName(),
                phone.getType().getName(),
                phone.isCharging() ? "充电中" : "充电失败",
                Integer.toHexString(phone.hashCode())
                );
    }
}
