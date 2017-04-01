package com.huoli.checkin.design.pattern.chain.commons;

import org.apache.commons.chain.Context;

public interface Command {

    boolean execute(Context context) throws Exception;

}
