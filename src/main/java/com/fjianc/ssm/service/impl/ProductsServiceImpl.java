package com.fjianc.ssm.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fjianc.ssm.dao.ProductsDao;
import com.fjianc.ssm.entity.Product;
import com.fjianc.ssm.enums.ProductStateEnum;
import com.fjianc.ssm.exception.ProductException;
import com.fjianc.ssm.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author FJianC
 */
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsDao productsDao;

    @Override
    public void insertProduct(Product product) {
        if (productException(product)) {
            productsDao.insertProduct(product);
        }
    }

    @Override
    public void deleteProduct(String id) {
        productsDao.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        if (productException(product)) {
            productsDao.updateProduct(product);
        }
    }

    @Override
    public Product selectById(String id) {
        Product product = productsDao.selectById(id);
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> list =productsDao.selectAll();
        return list;
    }

    private Boolean productException(Product product) {
        if (product != null) {
            int count;
            String str = product.getName();
            int len = str.length();
            for (count = 0; count < len; count++) {
                if (str.charAt(count) != ' ') {
                    break;
                }
            }
            if (len == count) {
                return false;
            }
            str = product.getPrice();
            len = str.length();
            if (len <= 0) {
                return false;
            }
            if (str.charAt(0) == '.' || str.charAt(len - 1) == '.') {
                return false;
            }
            for (count = 0; count < len; count++) {
                if (str.charAt(count) > '9' && str.charAt(count) < '0') {
                    if (str.charAt(count) != '.') {
                        break;
                    }
                }
            }
            if (len > count) {
                return false;
            }
            return true;
        }
        return false;
    }
}
