package com.yyh.nwpusurvivalmanual.utils.response;

import lombok.Data;

@Data
public class Result {

    private Integer code;
    private String message;
    private Object data;

    public Result(Object data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
    public static Result success(Object data) {
        return new Result(data,200,"success");
    }
    public static Result success(Object data, Integer code, String message) {
        return new Result(data,code,message);
    }
    public static Result fail(Object data, Integer code, String message) {
        return new Result(data,code,message);
    }
}