package com.huoli.checkin.result;

/**
 * TOP接口的状态结果集
 * @author wentao 2013/8/28
 *
 */
public enum TopResultCode {
        
    isv_missing_parameter("isv.missing-parameter", "缺少必要的参数"),
    
    isv_invalid_parameter("isv.invalid-parameter", "参数无效，格式不对、非法值、越界等"),
    
    isv_invalid_permission("isv.invalid-permission", "权限不够、非法访问"),
        
    isv_user_no_exist("isv.user-no-exist", "用户不存在"),
    
    isv_invalid_parameter_icid("isv.invalid-parameter:auction_id", "电子书商品数字id不存在或填写错误"),
    isv_invalid_parameter_chapter_tbid("isv.invalid-parameter:tbid", "电子书章节淘宝id不存在或填写错误"),
    isv_invalid_parameter_title("isv.invalid-parameter:title", "章节标题不能为空或标题长度超出限制（不能超过30个字）"),
    isv_invalid_parameter_content("isv.invalid-parameter:content", "内容长度超出限制,不能超过50000字"),
    isv_invalid_parameter_content_url("isv.invalid-parameter:content_url", "章节Url长度超出限制，不能超过500个字"),
    isv_invalid_parameter_content_blank("isv.invalid-parameter:content_blank", "章节内容和章节URL不能同时为空"),
    isv_invalid_parameter_isfree("isv.invalid-parameter:is_free", "收费方式只能是0或1,0：收费，1：免费"),
    
    /**
     * 添加或修改卷
     */
    isv_invalid_parameter_orderid("isv.invalid-parameter:order_id", "电子书商品卷序号id不存在或填写错误(卷序号不能大于300)"),
    isv_invalid_parameter_desc("isv.invalid-parameter:desc", "电子书卷信息简介长度超出限制"),
    /**
     * 添加章节
     */
    isv_invalid_parameter_volume_id("isv.invalid-parameter:volume_id", "卷id不存在或填写错误"),
    isv_invalid_parameter_pre_tbid("isv.invalid-parameter:pre_tbid", "上一个章节物理ID不合法或者上一个章节不存在"),
    isv_invalid_parameter_cp_cid("isv.invalid-parameter:cp_cid", "第三方的章节ID不合法或有重复的章节添加"),
    isv_invalid_parameter_status("isv.invalid-parameter:status", "电子书状态不合法。目前仅支持以下三种1：更新中，3：完本，2：暂停"),
    isv_invalid_parameter_bookprice_required("isv.invalid-parameter:bookprice_required", "当状态设置为完本,完本价是必填项"),
    isv_invalid_parameter_bookprice("isv.invalid-parameter:bookprice", "电子书完本价格不合法。当状态为完本（即status=3）时，必填；只支持两位小数点的正数，例如：12.50"),    
    isv_invalid_parameter_content_contenturl("isv.invalid-parameter:content_contenturl", "章节内容和章节地址不能两者都是空"),
    isv_invalid_parameter_serial_finished("isv.invalid-parameter:serial_finished", "该连载商品已经设置完结，不能添加章节"),
    isv_invalid_parameter_content_type("isv.invalid-parameter:content_type", "章节内容格式不一致，确认跟添加的第一个章节内容格式一致"),
    isv_invalid_parameter_icid_volumeid_unmatch("isv.invalid-parameter:icid_volumeid_unmatch", "商品ID和卷ID不匹配"),
    
    /**
     * 删除章节
     */
    isv_chaper_not_exist("isv.chapter-not-exist", "章节不存在或已删除"),
    isv_chaper_not_delete("isv.chapter-not-delete", "该章节不能被删除"),
    isv_chaper_not_delete_not_serial("isv.chapter-not-delete_not_serial", "该书不是连载中的状态，不能删除章节"),
    isv_chaper_not_delete_auditing("isv.chapter-not-delete_auditing", "该章节处于审核中的状态，不能删除章节"),
    /**
     * 修改章节
     */
    isv_word_count_invalid("isv.word-not-invalid", "章节字数不合法或收费字数大于章节总字数"),
    isv_chaper_not_update("isv.chapter-not-update", "待审核或审核中的章节不能被修改"),
    isv_chaper_no_update("isv.chapter-no-update", "没有需要修改的章节信息，请填入参数"),
    isv_invalid_parameter_content_not_allowed("isv.invalid-parameter:content_not_allowed", "content参数不允许传入"),
    isv_invalid_parameter_content_url_not_allowed("isv.invalid-parameter:content_url_not_allowed", "content_url参数不允许传入"),
    /**
     * 添加资源文件
     */
    isv_resource_not_found("isv.resource-not-found", "没有找到该文件ID的云盘文件"),
    isv_file_id_invalid("isv.invalid-parameter:file_id", "云盘文件ID小于0或没有找到对应ID的文件"),
    isv_res_type_invalid("isv.invalid-parameter:res_type", "资源类型不对，type只能是0或者1，（1：正文，0：试读）"),
    isv_resource_suffix_invalid("isv.invalid-parameter:suffix", "文件后缀和云盘文件后缀不相符"),
    isv_yunpan_token_failed("isv.yunpan-token-failed","获取云盘token信息失败，请检查client_id参数是否正确"),
    /**
     * isp类型错误
     */
    isp_service_unavailable("isp.service-unavailable", "服务不可用"),
    
    isp_null_pointer_exception("isp.null-pointer-exception", "空指针异常错误"),
    
    isp_remote_service_error("isp.remote-service-error", "连接远程服务错误"),
    
    ;
    
    
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private TopResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    /**
     * 通过代码获取enum对象
     * @param code
     * @return
     */
    public static TopResultCode getValue(String code){
        for (TopResultCode obj : values()) {
            if(obj.getCode().equals(code)){
                return obj;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return code + ":" + message;
    }
    
    
}
