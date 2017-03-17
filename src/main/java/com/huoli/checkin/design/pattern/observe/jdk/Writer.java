/**
 * 
 */
package com.huoli.checkin.design.pattern.observe.jdk;

import java.util.Observable;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月27日<br>
 */
//作者类，要继承自被观察者类  
public class Writer extends Observable {

    private String name;//作者的名称  

    private String lastNovel;//记录作者最新发布的小说  

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    //作者发布新小说了，要通知所有关注自己的读者  
    public void addNovel(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》！");
        lastNovel = novel;
        setChanged();
        notifyObservers();
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public String getName() {
        return name;
    }

}
