package com.a2dfire.yusuzi.roomwordsample.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.a2dfire.yusuzi.roomwordsample.R;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment,Fragment1.newInstance(), "Fragment1").commitAllowingStateLoss();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, FragmentTestActivity.class);
        context.startActivity(starter);
    }


}
