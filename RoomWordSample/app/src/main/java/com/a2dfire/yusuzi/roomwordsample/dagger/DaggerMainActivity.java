package com.a2dfire.yusuzi.roomwordsample.dagger;

import android.arch.persistence.room.Index;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a2dfire.yusuzi.roomwordsample.R;
import com.a2dfire.yusuzi.roomwordsample.dagger.named.B;
import com.a2dfire.yusuzi.roomwordsample.dagger.waimai.Baozi;
import com.a2dfire.yusuzi.roomwordsample.dagger.waimai.DaggerPlatform;
import com.a2dfire.yusuzi.roomwordsample.dagger.waimai.DaggerWaimaiPlatform;
import com.a2dfire.yusuzi.roomwordsample.dagger.waimai.Noddle;
import com.a2dfire.yusuzi.roomwordsample.dagger.waimai.ShangjiaAModule;
import com.a2dfire.yusuzi.roomwordsample.dagger.waimai.WaimaiPlatform;
import com.a2dfire.yusuzi.roomwordsample.dagger.waimai.ZhaiNan;
import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.DaggerXiaoChiComponent;
import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.Guazi;
import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.Huotuichang;
import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.XiaoChiComponent;

import org.w3c.dom.Node;

import javax.inject.Inject;
import javax.inject.Named;

public class DaggerMainActivity extends AppCompatActivity {

    @Inject
    @Named("A")
    int testValueA;

    @Inject
    @B
    int testValueB;


    @Inject
    Huotuichang huotuichang;
    @Inject
    Guazi guazi;

    @Inject
    Baozi baozi;
    @Inject
    Noddle noddle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);
        Button buttonInject = findViewById(R.id.btn_test_inject);
        Button buttonModule = findViewById(R.id.btn_test_module);
        Button buttonZhuru = findViewById(R.id.btn_test_zhuru);
        Button buttonInjectActivity = findViewById(R.id.btn_test_inject_activity);

        final ZhaiNan zhaiNan = DaggerPlatform.builder()
                .shangjiaAModule(new ShangjiaAModule("王小二米粉店"))
                .build()
                .waimai();
        buttonInject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DaggerMainActivity.this, zhaiNan.eat(), Toast.LENGTH_SHORT).show();
            }
        });
        XiaoChiComponent xiaoChiComponentModule= DaggerXiaoChiComponent.builder().build();

        final ZhaiNan zhaiNanModule= DaggerWaimaiPlatform.builder()
                .shangjiaAModule(new ShangjiaAModule("张三包子店"))
                .xiaoChiComponent(xiaoChiComponentModule)
                .build()
                .waimai();
        buttonModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DaggerMainActivity.this, zhaiNanModule.eat(), Toast.LENGTH_SHORT).show();
            }
        });

        final ZhaiNan zhaiNanZhuru = new ZhaiNan();
        XiaoChiComponent xiaoChiComponentZhuru= DaggerXiaoChiComponent.builder().build();
        WaimaiPlatform daggerWaimaiPlatformzhuru = DaggerWaimaiPlatform.builder()
                .shangjiaAModule(new ShangjiaAModule("楼外楼饭店"))
                .xiaoChiComponent(xiaoChiComponentZhuru)
                .build();
        daggerWaimaiPlatformzhuru.zhuru(zhaiNanZhuru);
        buttonZhuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DaggerMainActivity.this, zhaiNanZhuru.eat(), Toast.LENGTH_SHORT).show();
            }
        });

        final ZhaiNan zhaiNanInjectActivity = new ZhaiNan();
        XiaoChiComponent xiaoChiComponentInjectActivity= DaggerXiaoChiComponent.builder().build();
        WaimaiPlatform daggerWaimaiPlatformInjectActivity = DaggerWaimaiPlatform.builder()
                .shangjiaAModule(new ShangjiaAModule("黄山饭店"))
                .xiaoChiComponent(xiaoChiComponentInjectActivity)
                .build();
        daggerWaimaiPlatformInjectActivity.zhuru(zhaiNanInjectActivity);
        daggerWaimaiPlatformInjectActivity.inject(this);
        buttonInjectActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DaggerMainActivity.this, zhaiNanInjectActivity.eat()+testValueA, Toast.LENGTH_SHORT).show();
            }
        });

        testComponentDependency();
    }


    public void testComponentDependency(){
        Button buttonComponentDependency = findViewById(R.id.btn_test_component_dependency);

        XiaoChiComponent xiaoChiComponent= DaggerXiaoChiComponent.builder().build();

        WaimaiPlatform daggerWaimaiPlatformDependency = DaggerWaimaiPlatform.builder()
                .xiaoChiComponent(xiaoChiComponent)
                .shangjiaAModule(new ShangjiaAModule("黄龙饭店"))
                .build();

        daggerWaimaiPlatformDependency.inject(this);
        buttonComponentDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DaggerMainActivity.this,
                        baozi.toString()+" "+
                                noddle.toString()+" "
                                +guazi+""+huotuichang,Toast.LENGTH_LONG).show();
            }
        });

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, DaggerMainActivity.class);
        context.startActivity(starter);
    }
}
