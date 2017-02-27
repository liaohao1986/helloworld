/**
 * 
 */
package com.huoli.checkin.design.pattern.command;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月17日<br>
 */
public class Invoker {

//    /**
//     * 调用者持有命令对象
//     */
//    private Command command;
//
//    /**
//     * 设置命令对象
//     * @param command
//     */
//    public void setCommand(Command command) {
//        this.command = command;
//    }
//
//    public Command getCommand() {
//        return command;
//    }
    
    public void invoke(Command command) {
        command.execute();
    }

//    /**
//     * 重做命令
//     */
//    public void runCommand() {
//        command.redo();
//    }
//
//    /**
//     * 撤销命令
//     */
//    public void unDoCommand() {
//        command.undo();
//    }
}
