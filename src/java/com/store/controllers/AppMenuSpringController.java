package com.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/*", "/appMenuController/"})
public class AppMenuSpringController {

    @RequestMapping(value = "/")
    public ModelAndView index() {
        System.out.println("Index...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "processRequest")
    public ModelAndView processRequest(@RequestParam("page") String page) {

        ModelAndView modelAndView = new ModelAndView();

        if (page == null || page.trim().equals("")) {
            modelAndView.setViewName("../home");
            return modelAndView;
        }

        String pageSmall = page.toLowerCase();

        if (pageSmall.equals("home".toLowerCase())) {
            System.out.println("Home..444......");
            modelAndView.setViewName("home");

        } else if (pageSmall.equals("insertProduct".toLowerCase())) {
            modelAndView.setViewName("insertProduct");

        } else if (pageSmall.equals("showProducts".toLowerCase())) {
            // ArrayList l = (ArrayList) ProductRepo.listAllProduct();
            // StoreGetway getway = new StoreGetway();
            // ArrayList<ProductBean> l = (ArrayList<ProductBean>) getway.listAllProducts();
            modelAndView.setViewName("showProducts");
            //modelAndView.addObject("allProducts", l);
        } else {
            modelAndView.setViewName("errorPage");
        }
        return modelAndView;
    }

}
