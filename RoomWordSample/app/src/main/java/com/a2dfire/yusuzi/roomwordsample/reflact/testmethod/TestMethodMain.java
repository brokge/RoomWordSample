package com.a2dfire.yusuzi.roomwordsample.reflact.testmethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethodMain {

    public static void main(String[] args) {
        Class testCls = TestMethod.class;

        try {
            Method mStatic = testCls.getMethod("testStatic", null);
            mStatic.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        TestMethod t = new TestMethod();

        try {
            Method mAdd = testCls.getDeclaredMethod("add", int.class, int.class);
            mAdd.setAccessible(true);
            int result = (int) mAdd.invoke(t, 1, 2);
            System.out.println("add method result:" + result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        try {
            Method testExcep = testCls.getMethod("testException",null);
            try {
                testExcep.invoke(t, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                //e.printStackTrace();
                // 通过 InvocationTargetException.getCause() 获取被包装的异常
                System.out.println("testException occur some error,Error type is :"+e.getCause().getClass().getName());
                System.out.println("Error message is :"+e.getCause().getMessage());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }
}
