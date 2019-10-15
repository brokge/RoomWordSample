package com.a2dfire.yusuzi.roomwordsample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a2dfire.yusuzi.roomwordsample.R;
import com.a2dfire.yusuzi.roomwordsample.Word;
import com.a2dfire.yusuzi.roomwordsample.WordListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    private RecyclerView recyclerView;

    public static Fragment1 newInstance() {

        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        WordListAdapter wordListAdapter=new WordListAdapter(getContext());
        wordListAdapter.setWords(getWordList());
        recyclerView.setAdapter(wordListAdapter);
    }

    private List<Word> getWordList(){
        List<Word> wordList=new ArrayList<>();
        for (int i=0;i<20;i++) {
            wordList.add(new Word(i+""));
        }
        return wordList;
    }

    private void initView(View view) {
        recyclerView =view.findViewById(R.id.recycler_view);
    }
}
