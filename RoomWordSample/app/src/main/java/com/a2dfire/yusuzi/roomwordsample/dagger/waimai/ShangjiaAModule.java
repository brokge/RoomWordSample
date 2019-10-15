package com.a2dfire.yusuzi.roomwordsample.dagger.waimai;

import com.a2dfire.yusuzi.roomwordsample.dagger.named.B;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ShangjiaAModule {

    String restaurant;

    public ShangjiaAModule(String restaurant) {
        this.restaurant = restaurant;
    }

    @Provides
    public Baozi provideBaozi() {
        return new Baozi("豆沙包");
    }

    @Provides
    public Noddle provideNoddle(Tongyi tongyi) {
        return tongyi;
    }

    @Provides
    public String provideResturant() {
        return restaurant;
    }

    @Provides
    @Named("A")
    public int provideIntA(){
        return 111;
    }
    @Provides
    @B
    public int provideIntB(){
        return 222;
    }
}
