package com.seth.charge.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.seth.charge.demo.Chargeable.printResult;

public class ChargeTest {
    public static void main(String[] args) {
//        test1();
        Phone[] phones = {new Iphone(), new Android(), new XiaoMi()};
        Charger charger = new Charger();
        match(charger, phones, Type.values());
    }

    public static void match(Charger charger, Phone[] phones, Type[] types) {
        List<Phone> phoneList = new ArrayList<>(10000);
        while (phoneList.size() < 10000) {
            final Phone phone = phones[new Random().nextInt(phones.length)];
            final ChargingLine chargingLine = new ChargingLine(types[new Random().nextInt(types.length)]);

            charger.setChargingCable(chargingLine);
            charger.charge(phone);
            printResult(charger, phone);
            if (charger.getStatus() && phone.isCharging()) {
                isTrue(phone.isCharging(), phone.toString());
                phoneList.add(phone);
            }
        }

        phoneList.forEach(p -> isTrue(p.isCharging(), p.toString()));
    }

    private static void isTrue(boolean condition, Object output) {
        if (!condition) {
            throw new IllegalStateException(output.toString());
        }
    }

    private static void test1() {
        // 充电器-充电线:iphone
        Phone phone = new Iphone();
        Charger charger = new Charger(new ChargingLine(Type.IPHONE));
        // 给苹果手机充电
        charger.charge(phone);
        printResult(charger, phone); //  类型匹配成功, 充电中

        // 换安卓手机
        phone = new Android();
        // 换安卓充电线
        charger.setChargingCable(new ChargingLine(Type.ANDROID));
        charger.charge(phone);
        printResult(charger, phone); // 类型匹配成功, 充电中

        // 换苹果手机, 不换充电线（安卓）
        phone = new Iphone();
        charger.charge(phone);
        printResult(charger, phone); // 类型匹配失败，充电失败

        // 小米是安卓，充电线（安卓）
        phone = new XiaoMi();
        charger.charge(phone);
        printResult(charger, phone); // 类型匹配成功，充电中
    }
}
