package com.a2dfire.yusuzi.roomwordsample.dagger;

import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.XiaoChiComponent;
import com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi.XiaoChiModule;

import dagger.Component;

@Component(modules = {FoodModule.class, XiaoChiModule.class},dependencies = XiaoChiComponent.class)
public interface FoodComponent {
    //void aa(DaggerMainActivity daggerMainActivity);
}
