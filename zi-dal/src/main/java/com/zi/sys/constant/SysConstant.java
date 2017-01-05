package com.zi.sys.constant;

/**
 * Created by 汪梓文 on 2016/8/17.
 */

/**
 * 记录全局常量
 */
public enum SysConstant {
    YES("Y"),
    NO("N"),
    TRUE(true),
    FALSE(false);

    private SysConstant(String value) {
        this.value = value;
    }
    private SysConstant(boolean value) {
        this.booValue = value;
    }
    private SysConstant(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private String key;
    private String value;
    private boolean booValue;

    public boolean isBooValue() {
        return booValue;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
