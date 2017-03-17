package com.huoli.checkin.result;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 处理结果
 * @author shiyi.yl
 *
 */
public class EbookResultSupport<T> implements EbookResult<T> {

    private static final long serialVersionUID = -7824473126982446814L;

    //执行是否成功
    private boolean success = false;

    //实际返回结果
    private T module;

    //总记录数
    private int totalCount;

    //错误代码
    private String errorCode;

    //错误信息
    private String errorMsg;

    /**
     * 创建一个result
     */
    public EbookResultSupport() {

    }

    /**
     * 创建一个result
     * @param success
     */
    public EbookResultSupport(boolean success) {
        this.success = success;
    }

    /**
     * 创建一个result
     * @param errorCode
     * @param errorMsg
     */
    public EbookResultSupport(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    

    @Override
    public T getModule() {
        return module;
    }

    @Override
    public void setModule(T module) {
        this.module = module;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean isFailure() {
        return !isSuccess();
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public EbookResult<T> getFailResult(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        return this;
//        return new EbookResultSupport<T>(errorCode, errorMsg);
    }

    @Override
    public EbookResult<T> getFailResult(TopResultCode topResultCode) {
        return getFailResult(topResultCode.getCode(), topResultCode.getMessage());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
