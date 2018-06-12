package com.fjianc.ssm.enums;

public enum ProductStateEnum {
    
    SUCCESS(1, "成功"),
    END(0, "失败"),
    END_NAME(-1, "商品名称异常"),
    END_PRICE(-2, "商品价格异常");
    
    private int state;
    private String stateInfo;

    ProductStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    
    public static ProductStateEnum stateOf(int index) {
        for (ProductStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
