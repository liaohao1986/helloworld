/**
 * 
 */
package com.huoli.checkin.design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月17日<br>
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //        Command turnOnCommand = new TurnOnCommand();
        //        Command turnOffCommand = new TurnOffCommand();
        //        Command turnChangeCommand = new TurnChangeCommand();
        //创建命令对象，并设置它的接受者
        //        Command turnOnCommand = new TurnOnCommand(receiver);
        //        Command turnOffCommand = new TurnOffCommand(receiver);
        //        Command turnChangeCommand = new TurnChangeCommand(receiver);
        //        List<Command> commandList = new ArrayList<Command>();
        //        commandList.add(turnOnCommand);
        //        commandList.add(turnOffCommand);
        //        commandList.add(turnChangeCommand);
        //        for(Command command : commandList) {
        //            command.execute();
        //        }

        //创建接受者
//        Receiver receiver = new Receiver();
//        Command turnOnCommand = new TurnOnCommand(receiver);
//        Command turnOffCommand = new TurnOffCommand(receiver);
//        Command turnChangeCommand = new TurnChangeCommand(receiver);
        //创建调用者，将命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.invoke(new TurnOnCommand());
        invoker.invoke(new TurnOffCommand());
        invoker.invoke(new TurnChangeCommand());
        //        invoker.setCommand(turnOnCommand);
        //
        //        //这里可以测试一下
        //        invoker.runCommand();
        //        invoker.unDoCommand();

    }

}
