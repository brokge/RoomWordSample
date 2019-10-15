package com.a2dfire.yusuzi.roomwordsample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestViewModelActivity extends AppCompatActivity {
    TestViewModel mTestViewModel;

    int i = 0;

    TextView mShowChangeWord;
    TextView mTvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_model);
        Button button = findViewById(R.id.btn_change_word);
        mShowChangeWord = findViewById(R.id.tv_show_view_model_value);
        mTvText=findViewById(R.id.tv_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("新的字段" + i++);
                mTestViewModel.getWord().setValue(word);
            }
        });
        mTestViewModel = ViewModelProviders.of(this)
                .get(TestViewModel.class);

        mTestViewModel.getWord().observe(this, new Observer<Word>() {
            @Override
            public void onChanged(@Nullable Word word) {
                mShowChangeWord.setText(word.getWord());
                String text = mTvText.getText().toString();
                mTvText.setText(text + word.getWord());
            }
        });

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, TestViewModelActivity.class);
        context.startActivity(starter);
    }

}
