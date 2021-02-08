package com.company.services.impl;

import com.company.dao.IProductDAO;
import com.company.model.Product;
import com.company.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IProductServiceImpl implements IProductService {

    @Autowired
    IProductDAO productDAO;

    @Override
    public Product getProductByID(int id) {
        return this.productDAO.getProductByID(id);
    }

    @Override
    public void updateProduct(Product product) {
        Product productFromDb = this.productDAO.getProductByID(product.getId());
        productFromDb.setName(product.getName());
        productFromDb.setPrice(product.getPrice());
        productFromDb.setQuantity(product.getQuantity());
        productFromDb.setProducer(product.getProducer());
        productFromDb.setParametr1(product.getParametr1());
        productFromDb.setParametr2(product.getParametr2());
        productFromDb.setParametr3(product.getParametr3());

        this.productDAO.updateProduct(productFromDb);
    }

    @Override
    public List<Product> getAllProduct() {
        return this.productDAO.getAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }
}