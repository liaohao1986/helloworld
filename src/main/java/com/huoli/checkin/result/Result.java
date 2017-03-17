/**
 * 
 */
package com.huoli.checkin.result;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月16日<br>
 */
public interface Result extends Serializable {
    public static final String DEFAULT_MODEL_KEY = "_defaultModel";

    public abstract boolean isSuccess();

    public abstract void setSuccess(boolean paramBoolean);

    public abstract String getResultCode();

    public abstract void setResultCode(String paramResultCode);

    public abstract String getDefaultModelKey();

    public abstract Object getDefaultModel();

    public abstract void setDefaultModel(Object paramObject);

    public abstract void setDefaultModel(String paramString, Object paramObject);

    public abstract Map<String, Object> getModels();
}
