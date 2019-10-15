package com.a2dfire.yusuzi.roomwordsample.dagger.waimai;

import javax.inject.Inject;

public class ZhaiNan {
    @Inject
    Baozi baozi;
    @Inject
    Noddle noddle;

    @Inject
    String resturant;

    @Inject
    public ZhaiNan() {

    }

    public String eat() {
        StringBuilder sb = new StringBuilder();
        sb.append("我从 ");
        sb.append(resturant);
        sb.append("订的外卖，");
        sb.append("我吃的是");
        if (baozi != null) {
            sb.append(baozi.toString());
        }
        if (noddle != null) {
            sb.append(noddle.toString());
        }
        return sb.toString();
    }

}
