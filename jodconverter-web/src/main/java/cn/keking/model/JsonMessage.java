package cn.keking.model;


import java.io.Serializable;

public class JsonMessage implements Serializable {
    private boolean success;
    private int code;
    private String message;
    private Object data;
    private long total;
    private static String JSON = "json";

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public JsonMessage(boolean _success, Object data) {
        this.success = _success;
        if (_success) {
            this.code = 200;
        } else {
            this.code = 500;
        }

        this.data = data;
    }

    public JsonMessage() {
    }

    public JsonMessage(boolean _success, String msg) {
        this(_success, msg, (Object)null);
    }

    public JsonMessage(boolean _success, long total, Object data) {
        this.success = _success;
        if (_success) {
            this.code = 200;
        } else {
            this.code = 500;
        }

        this.total = total;
        this.data = data;
    }

    public JsonMessage(boolean _success, String msg, Object data) {
        this.success = _success;
        if (_success) {
            this.code = 200;
        } else {
            this.code = 500;
        }

        this.message = msg;
        this.data = data;
    }

    public JsonMessage(boolean _success, int code, String msg, Object data) {
        this.success = _success;
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public JsonMessage(int code, String msg) {
        this.success = false;
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

