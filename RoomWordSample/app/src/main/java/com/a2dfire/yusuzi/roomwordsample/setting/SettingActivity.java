package com.a2dfire.yusuzi.roomwordsample.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.a2dfire.yusuzi.roomwordsample.R;
import com.a2dfire.yusuzi.roomwordsample.TestViewModelActivity;
import com.a2dfire.yusuzi.roomwordsample.dagger.DaggerMainActivity;
import com.a2dfire.yusuzi.roomwordsample.fragment.FragmentTestActivity;
import com.a2dfire.yusuzi.roomwordsample.leak.LeakMainActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Intent> onClickListenerList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        SettingListAdapter settingListAdapter = new SettingListAdapter(this);
        settingListAdapter.setItems(getList());
        settingListAdapter.setOnItemClickListener(new SettingListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SettingBean settingBean) {
                Intent intent = onClickListenerList.get(settingBean.position);
                SettingActivity.this.startActivity(intent);
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(settingListAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private List<SettingBean> getList() {
        if (onClickListenerList != null && onClickListenerList.size() > 0) {
            onClickListenerList.clear();
        }
        List<SettingBean> list = new ArrayList<>();
        list.add(createSettingBean(0, "测试ViewModel", TestViewModelActivity.class));
        list.add(createSettingBean(1, "fragment测试", FragmentTestActivity.class));
        list.add(createSettingBean(2, "测试dagger2", DaggerMainActivity.class));
        list.add(createSettingBean(3, "测试内存泄露", LeakMainActivity.class));
        return list;
    }

    private SettingBean createSettingBean(int position, String tip, Class<? extends Activity> activityClass) {
        setOnClickListenerList(activityClass);
        SettingBean settingBean = new SettingBean();
        settingBean.setPosition(position);
        settingBean.setTitle(tip);
        return settingBean;
    }

    public void setOnClickListenerList(final Class<? extends Activity> activity) {
        if (onClickListenerList == null) {
            onClickListenerList = new ArrayList<>();
        }
        onClickListenerList.add(new Intent(SettingActivity.this, activity));

    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SettingActivity.class);
        context.startActivity(starter);
    }
}
