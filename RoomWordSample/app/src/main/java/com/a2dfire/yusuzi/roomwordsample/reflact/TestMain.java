package com.a2dfire.yusuzi.roomwordsample.reflact;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) {
        //TestModifier.class.getModifiers();

        //testField();
        testMethod();

    }

    public static void testMethod() {
        Class sunClass = DeclaredSunClass.class;

        try {
            Method method=sunClass.getDeclaredMethod("a",int.class);
            System.out.println(method.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        Method[] methods = sunClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Declared method :" + method.getName());
        }

        methods = sunClass.getMethods();
        for (Method method : methods) {
            System.out.println("Methods method :" + method.getName());
        }
    }

    public static void testField() {
        Class sunClass = DeclaredSunClass.class;
        try {
            Field field = sunClass.getDeclaredField("a");
            System.out.println(field.getName());
            field = sunClass.getDeclaredField("b");
            System.out.println(field.getName());
            field = sunClass.getDeclaredField("c");
            System.out.println(field.getName());

            field = sunClass.getField("C");
            System.out.println(field.getName());
        } catch (NoSuchFieldException e) {
            System.out.println("aa" + e.getMessage());
        }


        Field[] filed1 = sunClass.getDeclaredFields();

        for (Field f : filed1) {
            System.out.println("Declared Field :" + f.getName());
        }

        Field[] filed2 = sunClass.getFields();

        for (Field f : filed2) {
            System.out.println("Field :" + f.getName());
        }
    }
}
