package com.huoli.checkin.result;

/**
 * 状态结果集
 * @author liaohao 2012/7/13
 *
 */
public enum ResultCode {

    SUCCESS (1, "success"),
    
    /**
     * 应用程序异常
     */
    ERROR(0, "应用程序异常"),
    
    /**
     * 参数无效或者不符合规范
     */
    ERROR_PARAMETERS_IS_INVALID(9999, "参数无效或者不符合规范"),
    
    /**
     * 没有查询到符合条件的结果
     */
    ERROR_NO_RESULT(10000, "没有查询到符合条件的结果"),
    
    /**
     * HSF连接失败
     */
    ERROR_HSF_CONNECT_FAIL(10001, "HSF连接失败"),
    
    /**
     * 主键冲突
     */
    ERROR_PRIMARY_KEY_IS_EXIST(23000, "主键冲突"),
    
    
    //==============================================================================\\
    /**
     * 查询器不能为null
     */
    ERROR_QUERY_IS_NULL(100, "查询器不能为null"),
    
    /**
     * 查询条件没有设置分页参数
     */
    ERROR_QUERY_NOT_SET_PAGINATOR(200, "查询条件没有设置分页参数"),
    
    
    /**
     * 用户不存在
     */
    ERROR_QUERY_USER_NO_EXIST(300, "用户不存在"),
    /**
     * 用户已购买
     */
    ERROR_QUERY_USER_BOUGHT(310, "用户已购买"),
    /**
     * 用户未购买
     */
    ERROR_QUERY_USER_NO_BOUGHT(320, "用户未购买"),
    /**
     * 用户nick或用户id不正确
     */
    ERROR_QUERY_USER_PARAM_ERROR(330, "用户nick或用户id不正确"),
    
    
    /**
     * 商品不存在
     */
    ERROR_QUERY_ITEM_NO_EXIST(400, "商品不存在"),
    /**
     * 商品已下架
     */
    ERROR_QUERY_ITEM_DOWN_SHELF(410, "商品已下架"),
    /**
     * 不是数字商品
     */
    ERROR_QUERY_ITEM_NOT_SHUZI(420, "不是数字商品"),
    
    
    /**
     * 活动类型不存在
     */
    ACTIVITY_TYPE_NO_EXIST(500, "活动类型不存在"),
    
    /**
     * 活动类型无效或已过期
     */
    ACTIVITY_TYPE_INVALID(510, "活动类型无效或已过期"),
    
    /**
     * 不是参加该活动的商品
     */
    ACTIVITY_TYPE_NOT_ACTIVITY_ITEM(520, "不是参加该活动的商品"),
    
    /**
     * 该活动商品已经售完
     */
    ACTIVITY_TYPE_NO_QUANTITY(530, "该活动商品已经售完"),
    
    /**
     * 活动地址无效
     */
    ACTIVITY_TYPE_INVALID_URL(540, "活动地址无效"),
    
    ;
    
    private Integer code;
    private String message;
    
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    
    private ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    
    /**
     * 通过代码获取enum对象
     * @param code
     * @return
     */
    public static ResultCode valueOf(Integer code){
        for (ResultCode obj : values()) {
            if(obj.getCode().equals(code)){
                return obj;
            }
        }
        return null;
    }
    
    public String toString(){
        return code + ":" + message;
    }
    
}
