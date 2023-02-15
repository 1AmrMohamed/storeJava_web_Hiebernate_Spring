package com.store.controllers;

import com.store.beans.ProductBean;
import com.store.bll.StoreGetway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/operationsController/"})
public class AppOperationSpringController {
    
    @Autowired
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    
    @RequestMapping(value = "insertNewProduct")
    public ModelAndView insertNewProduct(@RequestParam("targetPage") String targetPage, @RequestParam("productId") String productId, @RequestParam("productName") String productName,
            @RequestParam("productPrice") String productPrice, @RequestParam("productQty") String productQty) {

        System.out.println(">>>>>insertProduct <<<<<< *****************");
        ModelAndView modelAndView = new ModelAndView();
        ProductBean productBean = new ProductBean();

        productBean.setProductId(Integer.parseInt(productId));
        productBean.setProductName(productName);
        productBean.setProductPrice(Integer.parseInt(productPrice));
        productBean.setProductQty(Integer.parseInt(productQty));

        StoreGetway getway = context.getBean("storeGetway", StoreGetway.class);
        getway.insertProduct(productBean);
        modelAndView.setViewName(targetPage);
        return modelAndView;
    }
}
