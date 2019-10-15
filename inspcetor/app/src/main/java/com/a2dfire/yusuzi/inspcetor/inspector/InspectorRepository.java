package com.a2dfire.yusuzi.inspcetor.inspector;

import java.util.LinkedHashMap;

public class InspectorRepository {

    public static final class SingleHolder {
        static InspectorRepository instance = new InspectorRepository();
    }

    public static InspectorRepository getInstance() {
        return SingleHolder.instance;
    }

    //初始化默认 检查对象
    InspectorRepository() {
        for (String key : InspectMap.inspectMap.keySet()) {
            register(createInstance(InspectMap.inspectMap.get(key)));
        }
    }

    public <T> T createInstance(Class<T> cls) {
        T obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
            obj = null;
        }
        return obj;
    }

    private LinkedHashMap<String, Inspector> inspectorLinkedList = new LinkedHashMap<>();

    public LinkedHashMap<String, Inspector> getInspectorList() {
        return inspectorLinkedList;
    }

    public void register(Inspector inspector) {
        if (!inspectorLinkedList.containsKey(inspector.getClass().getSimpleName())) {
            inspectorLinkedList.put(inspector.getClass().getSimpleName(), inspector);
        }
    }

    public void unRegister(Inspector inspector) {
        inspectorLinkedList.remove(inspector.getClass().getSimpleName());
    }

    public void unAllRegister() {
        inspectorLinkedList = null;
    }
}
