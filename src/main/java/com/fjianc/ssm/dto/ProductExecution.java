package com.fjianc.ssm.dto;

import com.fjianc.ssm.entity.Product;
import com.fjianc.ssm.enums.ProductStateEnum;

public class ProductExecution {

    private String id;
    private int state;
    private String stateInfo;
    private Product product;

    public ProductExecution(String id, ProductStateEnum stateEnum, Product product) {
        this.id = id;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.product = product;
    }

    public ProductExecution(String id, ProductStateEnum stateEnum) {
        this.id = id;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
