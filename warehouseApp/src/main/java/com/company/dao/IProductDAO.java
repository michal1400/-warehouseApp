package com.company.dao;

import com.company.model.Product;
import java.util.List;

public interface IProductDAO {
    void addProduct(Product product);
    Product getProductByID(int id);
    void updateProduct(Product product);
    List<Product> getAllProduct();
}
