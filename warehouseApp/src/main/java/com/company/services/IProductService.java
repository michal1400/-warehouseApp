package com.company.services;

import com.company.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    Product getProductByID(int id);
    void updateProduct(Product product);
    List<Product> getAllProduct();
}
