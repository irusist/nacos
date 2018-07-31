package com.alibaba.nacos.client.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author zhulixin
 */
public class BatchHttpResult<T> {
    private boolean success = true;
    private int statusCode;
    private String statusMsg;
    private String responseMsg;
    private List<T> result = new ArrayList();

    public BatchHttpResult() {
    }

    public BatchHttpResult(boolean success, int statusCode, String statusMsg, String responseMsg) {
        this.success = success;
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.responseMsg = responseMsg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getResponseMsg() {
        return this.responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public List<T> getResult() {
        return this.result;
    }

    public String toString() {
        return "BatchHttpResult [success=" + this.success + ", statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", result=" + this.result + "]";
    }
}
