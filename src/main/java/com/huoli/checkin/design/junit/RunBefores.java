/**
 * 
 */
package com.huoli.checkin.design.junit;

import java.util.List;

import org.junit.runners.model.FrameworkMethod;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月17日<br>
 */
public class RunBefores implements Statement {

    private final Statement next;

    private final Object target;

    private final List<FrameworkMethod> befores;

    public RunBefores(Statement next, List<FrameworkMethod> befores, Object target) {
        this.next = next;
        this.befores = befores;
        this.target = target;
    }

    /** 
     * @throws Throwable
     * @see com.huoli.checkin.design.junit.Statement#evaluate()
     */
    @Override
    public void evaluate() throws Throwable {
        for (FrameworkMethod before : befores) {
            before.invokeExplosively(target);
        }
        next.evaluate();
    }

}
