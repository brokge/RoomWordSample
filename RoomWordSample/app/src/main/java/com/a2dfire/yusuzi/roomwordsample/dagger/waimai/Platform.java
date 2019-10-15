package com.a2dfire.yusuzi.roomwordsample.dagger.waimai;

import dagger.Component;

@Component(modules = ShangjiaAModule.class)
public interface Platform {
    ZhaiNan waimai();
}
