package com.a2dfire.yusuzi.roomwordsample.reflact.testAutoDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testAutoDriveMain {

    //反射的具体使用
    //涉及反射中 method ， constructor，enum 。
    public static void main(String[] args) {
        AutoDrive car = new AutoDrive();
        car.drive();
        autoDrive();

    }

    public static void autoDrive() {
        Class cls = AutoDrive.class;
        try {
            //构造实例
            Constructor cos = cls.getConstructor(String.class, AutoDrive.Color.class);
            try {
                AutoDrive autoDrive = (AutoDrive) cos.newInstance("tesla", AutoDrive.Color.REN);
                Method method = cls.getMethod("drive");
                System.out.println("=================\n自动驾驶马上开始\n=========");
                //method 执行
                method.invoke(autoDrive, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

