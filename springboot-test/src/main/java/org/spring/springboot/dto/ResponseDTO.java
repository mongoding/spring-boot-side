package org.spring.springboot.dto;


import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {


    private static final long serialVersionUID = 1L;

    private boolean success;

    private int code;

    private String msg;

    private T data;

    public ResponseDTO() {
    }

    public ResponseDTO(int code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public ResponseDTO(boolean success, int code, String msg, T data) {
        super();
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 成功结果 (code="1",msg="",data=data)
     *
     * @param data
     * @return
     */
    public static <R> ResponseDTO<R> success(R data, String msg) {
        ResponseDTO<R> result = new ResponseDTO<R>();
        result.setSuccess(true);
        result.setCode(1);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <R> ResponseDTO<R> success(R data) {

        return success(data, null);
    }

    public static <R> ResponseDTO<R> success() {
        return success(null);
    }

    /**
     * 失败结果
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static <R> ResponseDTO<R> error(int code, String msg, R data) {
        ResponseDTO<R> result = new ResponseDTO<R>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <R> ResponseDTO<R> error() {

        return error(null);
    }

    public static <R> ResponseDTO<R> error(String msg) {

        return error(-1, msg);
    }

    public static <R> ResponseDTO<R> error(int code, String msg) {

        return error(code, msg, null);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO [success=" + success + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }


}
