package com.a2dfire.yusuzi.roomwordsample.reflact.testenum;

import java.lang.reflect.Field;
import java.util.Arrays;

public class TestEnumMain {
    public static void main(String[] args) {

        Class clz = State.class;

        if (clz.isEnum()) {
            System.out.println(clz.getName() + " is enum");
            System.out.println(Arrays.asList(clz.getEnumConstants()));
            Field[] fs = clz.getDeclaredFields();
            for (Field f : fs) {
                if (f.isEnumConstant()) {
                    System.out.println(f.getName() + "is enumConstant");
                } else {
                    System.out.println(f.getName() + "is not EnumConstant");
                }
            }
            Class cTestEnum = TestEnum.class;
            TestEnum testEnum =new TestEnum();

            try {
                Field f= cTestEnum.getDeclaredField("state");
                f.setAccessible(true);
                try {
                    State state=(State)f.get(testEnum);
                    System.out.println("state current is "+state);
                    f.set(testEnum,State.STOPPING);
                    System.out.println("state current is  "+ testEnum.getState());

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

    }
}
