package com.company.controllers;

import com.company.model.Product;
import com.company.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping(value = "/product")
@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public String listProducts (Model theModel){
        List<Product> productList = productService.getAllProduct();
        theModel.addAttribute("products", productList);
        return "list-products";
    }

    @RequestMapping("/add")
    public String showForm (Model theModel){
        Product product = new Product();
        theModel.addAttribute("product", product);
        return "add-product";
    }

    @RequestMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.addProduct(product);
        return "redirect:/main-menu";
    }

    @RequestMapping("/out")
    public String showFormOut(Model theModel){
        Product product = new Product();
        theModel.addAttribute("product", product);
        return "product-out";
    }

    @RequestMapping("/productOut")
    public String outProduct(@ModelAttribute("product") Product product){
        Product currentProduct = productService.getProductByID(product.getId());
        currentProduct.out(product.getQuantity());
        productService.updateProduct(currentProduct);
        return "redirect:/main-menu";
    }

    @RequestMapping("/in")
    public String showFormIn(Model theModel){
        Product product = new Product();
        theModel.addAttribute("product", product);
        return "product-in";
    }

    @RequestMapping("/productIn")
    public String inProduct(@ModelAttribute("product") Product product){
        Product currentProduct = productService.getProductByID(product.getId());
        currentProduct.in(product.getQuantity());
        System.out.println(currentProduct);
        productService.updateProduct(currentProduct);
        return "redirect:/main-menu";
    }

}
