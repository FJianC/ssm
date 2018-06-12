package com.fjianc.ssm.dao;

import com.fjianc.ssm.entity.Product;

import java.util.List;

/**
 * @author FJianC
 */
public interface ProductsDao {

    void insertProduct(Product product);

    void deleteProduct(String id);

    void updateProduct(Product product);

    Product selectById(String id);

    List<Product> selectAll();

}
