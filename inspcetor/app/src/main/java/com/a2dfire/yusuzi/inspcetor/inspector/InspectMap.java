package com.a2dfire.yusuzi.inspcetor.inspector;

import com.a2dfire.yusuzi.inspcetor.DefaultInspector;
import com.a2dfire.yusuzi.inspcetor.KoubeiInspector;

import java.util.HashMap;
import java.util.Map;

public class InspectMap {

    public static final Map<String, Class<? extends Inspector>> inspectMap;

    static {
        inspectMap = new HashMap<>();
        inspectMap.put("default", DefaultInspector.class);
        inspectMap.put("openKoubei", KoubeiInspector.class);
    }

}
