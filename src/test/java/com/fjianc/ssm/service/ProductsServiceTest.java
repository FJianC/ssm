package com.fjianc.ssm.service;

import com.fjianc.ssm.dao.ProductsDao;
import com.fjianc.ssm.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author FJianC
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class ProductsServiceTest {

    //注入Service实现类依赖
    @Autowired
    private ProductsService productsService;

    @Test
    public void testInsertProduct() {
        Product product = new Product();
        product.setName("华为P20Pro");
        product.setPrice("4800");
        product.setDetail("买微单送手机");
        productsService.insertProduct(product);

        testSelectAll();
    }

    @Test
    public void testDeleteProduct() {
        String id = "5";
        productsService.deleteProduct(id);
        testSelectAll();
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("小米8探索版");
        product.setPrice("3799");
        product.setDetail("黑科技");
        productsService.updateProduct(product);
        testSelectAll();
    }

    @Test
    public void testSelectById() {
        String id = "1";
        Product product = productsService.selectById(id);
        System.out.println(product.getName());
    }

    @Test
    public void testSelectAll() {
        List<Product> list = productsService.selectAll();
        for (Product product : list) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " + product.getDetail());
        }
    }

}
