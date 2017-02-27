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
public class TurnChangeCommand implements Command {
    private Receiver receiver;

//    public TurnChangeCommand(Receiver receiver) {
//        this.receiver = receiver;
//    }

    /** 
     * 
     * @see com.huoli.checkin.design.pattern.command.Command#execute()
     */
    @Override
    public void execute() {
        System.out.println("执行换台命令...");
//        receiver.action();
    }

    /** 
     * 
     * @see com.huoli.checkin.design.pattern.command.Command#undo()
     */
    @Override
    public void undo() {
        receiver.unAction();
    }

    /** 
     * 
     * @see com.huoli.checkin.design.pattern.command.Command#redo()
     */
    @Override
    public void redo() {
        receiver.reAction();
    }

}
