package com.huoli.checkin.ioc;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

public class IocContainer implements Container{
    
    /**
     * 保存所有bean对象，格式为 com.xxx.Person : @52x2xa
     */
    private Map<String, Object> beans;
    
    /**
     * 存储bean和name的关系
     */
    private Map<String, String> beanKeys;
    
    public IocContainer() {
        this.beans = new ConcurrentHashMap<String, Object>();
        this.beanKeys = new ConcurrentHashMap<String, String>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(Class<T> clazz) {
        String name = clazz.getName();
        Object object  =beans.get(name);
        if(object!=null) {
            return (T)object;
        }
        return null;
    }

    @Override
    public <T> T getBeanByName(String name) {
        String className = beanKeys.get(name);
        Object object = beans.get(className);
        if(object!=null) {
            return (T)object;
        }
        return null;
    }

    @Override
    public Object registerBean(Object bean) {
        String name = bean.getClass().getName();
        beanKeys.put(name, name);
        beans.put(name, bean);
        return bean;
    }

    @Override
    public Object registerBean(Class<?> clazz) {
        String name = clazz.getName();
        beanKeys.put(name, name);
        Object bean = null;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        beans.put(name, bean);
        return bean;
    }

    @Override
    public Object registerBean(String name, Object bean) {
        String className = bean.getClass().getName();
        beanKeys.put(name, className);
        beans.put(className, bean);
        return bean;
    }

    @Override
    public Set<String> getBeanNames() {
        return beanKeys.keySet();
    }

    @Override
    public void remove(Class<?> clazz) {
        String className = clazz.getName();
        if(null != className && !className.equals("")){
            beanKeys.remove(className);
            beans.remove(className);
        }
    }

    @Override
    public void removeByName(String name) {
        String className = beanKeys.get(name);
        if(null != className && !className.equals("")){
            beanKeys.remove(name);
            beans.remove(className);
        }
    }

    @Override
    public void initWired() {
        Iterator<Entry<String, Object>> it = beans.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            Object object = entry.getValue();
            injection(object);
        }
    }

    /**
     * 注入对象
     * @param object
     */
    public void injection(Object object) {
    }
    
    private Object recursiveAssembly(Class<?> clazz){
        if(null != clazz){
            return this.registerBean(clazz);
        }
        return null;
    }

}
