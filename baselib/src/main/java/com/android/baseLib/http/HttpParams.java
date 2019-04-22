package com.android.baseLib.http;

import com.yanzhenjie.nohttp.Binary;
import com.yanzhenjie.nohttp.rest.Request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/15 3:19 PM
 */
public class HttpParams {

    private List<Param> params;

    public HttpParams() {
        this.params = new ArrayList<>();
    }


    public void put(String key, Object value) {
        Param param = new Param();
        param.setKey(key);
        param.setValue(value);
        params.add(param);
    }

    public void addParams(Request request) {
        for (Param param : params) {
            Object value = param.getValue();
            if (value instanceof String) {
                request.add(param.getKey(), (String) value);
            } else if (value instanceof Integer) {
                request.add(param.getKey(), (Integer) value);
            } else if (value instanceof Long) {
                request.add(param.getKey(), (Long) value);
            } else if (value instanceof Boolean) {
                request.add(param.getKey(), (Boolean) value);
            } else if (value instanceof Float) {
                request.add(param.getKey(), (Float) value);
            } else if (value instanceof Double) {
                request.add(param.getKey(), (Double) value);
            } else if (value instanceof Binary) {
                request.add(param.getKey(), (Binary) value);
            } else if (value instanceof BigDecimal) {
                request.add(param.getKey(), String.valueOf(value));
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Param param : params) {
            Object value = param.getValue();
            buffer.append(param.getKey() + "=");
            if (value instanceof Binary) {
                buffer.append(((Binary) value).getFileName());
            } else {
                buffer.append(value);
            }
            buffer.append("&");
        }
        return buffer.length() == 0 ? "" : buffer.deleteCharAt(buffer.length() - 1).toString();
    }

    class Param {
        private String key;
        private Object value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

}
