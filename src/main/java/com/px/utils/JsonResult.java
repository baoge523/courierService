package com.px.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 宝哥
 * @date 2019/6/11
 * TODO
 */
public class JsonResult {

    private int  statusCode;   // 200 成功  100 失败

    private String message;    // 提示信息

    private Map<String,Object> datas = new HashMap<>();   // 用来存放传递的数据

    /**
     * 默认情况下 成功操作
     */
    public JsonResult() {
        this(200,"");
    }

    public JsonResult(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    /**
     * 将数据存放到map中去
     * @param name
     * @param value
     * @return
     */
    public JsonResult  addData(String name,Object value){
        datas.put(name,value);
        return this;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }
}
