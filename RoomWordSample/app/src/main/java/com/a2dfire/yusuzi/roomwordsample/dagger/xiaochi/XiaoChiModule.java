package com.a2dfire.yusuzi.roomwordsample.dagger.xiaochi;

import dagger.Module;
import dagger.Provides;

@Module
public class XiaoChiModule {
    @Provides
    public Guazi provideGuazi(){
        return  new Guazi();
    }
    @Provides
    public Huotuichang provideHuotuichang(){
        return new Huotuichang();
    }
}
