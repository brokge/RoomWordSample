package com.a2dfire.yusuzi.inspcetor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.a2dfire.yusuzi.inspcetor.inspector.InspectExecutor;

import java.util.LinkedList;
import java.util.List;

public class ShopListActivity extends AppCompatActivity implements ShopPageAdapter {

    List<String> inspectorRuler;

    InspectExecutor<SimpleShop, SimpleShop> executor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inspectorRuler = new LinkedList<>();
    }

    @Override
    public SimpleShop respect(SimpleShop simpleShop) {
        if (executor == null) {
            executor = new InspectExecutor<>();
        }
        executor.setInspectorRuler(inspectorRuler);

        return executor.execute(simpleShop);
    }

    @Override
    public StatusReason respectAllSelect() {
        return null;
    }
}
