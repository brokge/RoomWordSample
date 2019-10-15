package com.a2dfire.yusuzi.roomwordsample.dagger.waimai;

import com.a2dfire.yusuzi.roomwordsample.dagger.DaggerMainActivity;
import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.XiaoChiComponent;
import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.XiaoChiModule;

import dagger.Component;

@Component(modules = {ShangjiaAModule.class, XiaoChiModule.class},dependencies = XiaoChiComponent.class)
public interface WaimaiPlatform {
    ZhaiNan waimai();

    void zhuru(ZhaiNan zhaiNan);

    void inject(DaggerMainActivity mainActivity);
}
