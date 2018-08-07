package com.huoli.checkin.design.cache;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
public abstract class DataGroupUtil<T> {

    /**
     * 分组
     */
    public List<List<T>> group(List<T> entityList) {
        Map<String, List<T>> entityMap = groupMap(entityList);
        List<List<T>> entityGroupList = Lists.newArrayList();
        for (Entry<String, List<T>> entry : entityMap.entrySet()) {
            entityGroupList.add(entry.getValue());
        }
        return entityGroupList;
    }

    /**
     * 分组成一个Map
     */
    public Map<String, List<T>> groupMap(List<T> entityList) {
        Map<String, List<T>> entityMap = Maps.newHashMap();
        for (T entity : entityList) {
            String key = getKey(entity);
            if (key == null) {
                continue;
            }
            List<T> entityGroup = entityMap.get(key);
            if (entityGroup == null) {
                entityMap.put(key, Lists.newArrayList());
            }
            entityGroup.add(entity);
        }
        return entityMap;
    }

    /**
     * 获取分组依据key
     */
    public abstract String getKey(T entity);

}
