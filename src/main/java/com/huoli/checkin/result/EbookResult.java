package com.huoli.checkin.result;

import java.io.Serializable;

/**
 * 处理结果
 * @author shiyi.yl
 * 
 *
 */
public interface EbookResult<T> extends Serializable{

    /**
     * 是否执行成功
     * @return
     */
    boolean isSuccess();
    
    void setSuccess(boolean success);
    
    boolean isFailure();

    EbookResult<T> getFailResult(String errorCode, String errorMsg);
    
    EbookResult<T> getFailResult(TopResultCode topResultCode);
    
    /**
     * 执行的返回结果
     * @return
     */
    T getModule();
    
    void setModule(T module);
    
    /**
     * 返回结果集的总记录数
     * @return
     */
    int getTotalCount();
    
    void setTotalCount(int totalCount);
    
    /**
     * 错误代码
     * @return
     */
    String getErrorCode();
    
    void setErrorCode(String errorCode);
    
    /**
     * 错误信息
     * @return
     */
    String getErrorMsg();
    
    void setErrorMsg(String errorMsg);
    
    
}
