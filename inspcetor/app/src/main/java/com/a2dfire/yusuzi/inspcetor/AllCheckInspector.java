package com.a2dfire.yusuzi.inspcetor;

import com.a2dfire.yusuzi.inspcetor.inspector.Inspector;

import java.util.List;

public class AllCheckInspector implements Inspector<List<SimpleShop>, StatusReason> {

    @Override
    public StatusReason inspect(List<SimpleShop> simpleShops) {
        return null;
    }

}
