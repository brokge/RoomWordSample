package com.a2dfire.yusuzi.inspcetor.inspector;


import java.util.LinkedHashMap;
import java.util.List;

public class InspectExecutor<T, R> {

    //有序
    private List<String> inspectorRuler;

    public void setInspectorRuler(List<String> inspectorRuler) {
        this.inspectorRuler = inspectorRuler;
    }

    @SuppressWarnings("unchecked")
    public R execute(T t) {
        R r = null;
        if (inspectorRuler != null && inspectorRuler.size() > 0) {
            LinkedHashMap<String, Inspector> linkedHashMap = InspectorRepository.getInstance().getInspectorList();
            for (String rulerKey : inspectorRuler) {
                if (linkedHashMap.containsKey(rulerKey)) {
                    Inspector<T, R> inspector = linkedHashMap.get(rulerKey);
                    r = inspector.inspect(t);
                    if (r != null) {
                        break;
                    }
                }
            }
        }
        if (r == null) {
            return (R) t;
        } else {
            return r;
        }
    }
}
