package com.company.dao.impl;

import com.company.dao.IProductDAO;
import com.company.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    Connection connection;

    @Override
    public void addProduct(Product product) {

        String sql = "INSERT INTO product ( `name`, `price`, `quantity`, `producer`, `parametr_1`, `parametr_2`, `parametr_3`) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.setString(5, product.getParametr1());
            preparedStatement.setString(6, product.getParametr2());
            preparedStatement.setString(7, product.getParametr3());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public Product getProductByID(int id) {

        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("producer"),
                        resultSet.getString("parametr_1"),
                        resultSet.getString("parametr_2"),
                        resultSet.getString("parametr_3"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE product SET name = ?, price = ?, quantity = ?, producer = ?, parametr_1 = ?, parametr_2 = ?, parametr_3 = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.setString(5, product.getParametr1());
            preparedStatement.setString(6, product.getParametr1());
            preparedStatement.setString(7, product.getParametr1());
            preparedStatement.setInt(8, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product;";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("producer"),
                        resultSet.getString("parametr_1"),
                        resultSet.getString("parametr_2"),
                        resultSet.getString("parametr_3")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}
