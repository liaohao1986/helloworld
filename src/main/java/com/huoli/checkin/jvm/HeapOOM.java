/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.jvm;

import java.util.ArrayList;
import java.util.List;

/** 
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
 * -XX:+HeapDumpOnOutOfMemoryError 
 *  -XX:+HeapDumpOnOutOfMemoryError
    -XX:HeapDumpPath=c:/memoryLeakDemo.hprof
    -XX:+PrintGCDetails 
    -XX:+PrintGCDateStamps 
    -XX:+PrintGCApplicationConcurrentTime
    -XX:+PrintGCApplicationStoppedTime  
    -Xloggc:c:/memoryLeakDemoGc.log     
 * 
 *  
 * @author Nicholas 
 * Java堆溢出 
 * Java 堆用于存储对象实例，只要不断的创建对象，并且保证GC Roots到对象之间有可达路径来避免垃圾回收机制清除这些对象 
 * 那么当对象数量到达最大堆的容量限制后就会产生内存溢出异常 
 */

/* 
 * -Xms20M : 堆的最小值为20m 
 * -Xmx20M : 堆的最大值为20m，最大值和最小值相同，可以避免堆自动扩展 
 * -Xmn10M : 新生代大小为10m 
 * -XX:+PrintGCDetails : 打印辅助信息 
 * -XX:SurvivorRatio=8 : Java 堆中的Eden区与Survivor区的大小比值，设置为8,则两个Survivor区与一个Eden区的比值为2:8,一个Survivor区占整个年轻代的1/10 
 * -XX:+HeapDumpOnOutOfMemoryError : 当出现内存溢出异常时，dump出当前的内存转储快照信息以便后期分析 
 */

/** 
 * 如何处理堆内存溢出？ 
 * 通过EMA eclipse memory analyzer 打开堆内存转储文件 
 * 首先分清是内存泄露还是内存溢出 
 * 如果是内存泄露：通过工具查看泄露对象到GC Roots的引用链，然后找出泄露对象是通过怎样的路径与GC roots 相关联并导致垃圾回收器无法自动回收他们的 
 * 如果不存在泄露，也就是说内存中的对象还活着，那就应当检查虚拟机的堆参数 -Xmx -Xms 是否可以适当的调整 
 * 
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<HeapOOM.OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}