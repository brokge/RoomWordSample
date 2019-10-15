package com.a2dfire.yusuzi.roomwordsample.leak;

import android.content.Context;

public class SingleInstance {

    private static SingleInstance sInstance;

    private Context mContext;

    private SingleInstance(Context context) {
        this.mContext = context;
    }

    public static SingleInstance getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SingleInstance(context);
        }
        return sInstance;
    }
}
