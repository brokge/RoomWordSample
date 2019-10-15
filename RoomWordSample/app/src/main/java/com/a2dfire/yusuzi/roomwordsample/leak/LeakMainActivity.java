package com.a2dfire.yusuzi.roomwordsample.leak;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a2dfire.yusuzi.roomwordsample.R;

public class LeakMainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_main);
        button = findViewById(R.id.btn_text_leak);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeakActivity.start(LeakMainActivity.this);
            }
        });
    }
    public static void start(Context context) {
        Intent starter = new Intent(context, LeakMainActivity.class);
        context.startActivity(starter);
    }

}
