package com.a2dfire.yusuzi.roomwordsample.dagger.waimai;

import javax.inject.Inject;

public class Baozi {
    String name;

    @Inject
    public Baozi() {
        name="小笼包";

    }

    public Baozi(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
