package com.fjianc.ssm.dao;

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
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ProductsDaoTest {

    //注入Dao实现类依赖
    @Autowired
    private ProductsDao productsDao;

    @Test
    public void testInsertProduct() {
        Product product = new Product();
        product.setName("华为P20");
        product.setPrice("3800");
        product.setDetail("买数码相机送手机");
        productsDao.insertProduct(product);
        testSelectAll();
    }

    @Test
    public void testDeleteProduct() {
        String id = "2";
        productsDao.deleteProduct(id);
        testSelectAll();
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("小米8");
        product.setPrice("2699");
        product.setDetail("性价比之王");
        productsDao.updateProduct(product);
        testSelectAll();
    }

    @Test
    public void testSelectById() {
        String id = "1";
        Product product = productsDao.selectById(id);
        System.out.println(product.getName());
    }

    @Test
    public void testSelectAll() {
        List<Product> list = productsDao.selectAll();
        for (Product product : list) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " + product.getDetail());
        }
    }
}
