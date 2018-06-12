package com.fjianc.ssm.controller;

import com.fjianc.ssm.entity.Product;
import com.fjianc.ssm.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/products")//url:模块/资源/{}/细分
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Product> list = productsService.selectAll();
        model.addAttribute("list", list);
        return "list";
    }


}
