package com.huoli.checkin.result;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ResultSupport implements Result {
    private static final long serialVersionUID = 3976733653567025460L;
    private boolean success = true;
    private String resultCode;
    private Map<String, Object> models = new HashMap<String, Object>(4);
    private String defaultModelKey;

    public ResultSupport() {
    }

    public ResultSupport(boolean success) {
        this(success, null);
    }

    public ResultSupport(boolean success, String resultCode) {
        this.success = success;
        this.resultCode = resultCode;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getDefaultModelKey() {
        return StringUtils.defaultIfEmpty(this.defaultModelKey, "_defaultModel");
    }

    public Object getDefaultModel() {
        return this.models.get(getDefaultModelKey());
    }

    public void setDefaultModel(Object model) {
        setDefaultModel("_defaultModel", model);
    }

    public void setDefaultModel(String key, Object model) {
        this.defaultModelKey = StringUtils.defaultIfEmpty(key, "_defaultModel");
        this.models.put(key, model);
    }

    public Map<String, Object> getModels() {
        return this.models;
    }

}
