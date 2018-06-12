package com.fjianc.ssm.service;

import com.fjianc.ssm.entity.Product;

import java.util.List;

/**
 * @author FJianC
 */
public interface ProductsService {

    void insertProduct(Product product);

    void deleteProduct(String id);

    void updateProduct(Product product);

    Product selectById(String id);

    List<Product> selectAll();

}
