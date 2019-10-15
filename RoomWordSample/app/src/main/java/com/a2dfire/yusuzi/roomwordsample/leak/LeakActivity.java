package com.a2dfire.yusuzi.roomwordsample.leak;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a2dfire.yusuzi.roomwordsample.R;

public class LeakActivity extends AppCompatActivity {

    SingleInstance singleInstance;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        //singleInstance = SingleInstance.getInstance(this);
        mName = "yusuzi";
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LeakActivity.class);
        context.startActivity(starter);
    }
}
