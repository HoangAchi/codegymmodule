package com.codegym.demoClothingManagement.service;

import com.codegym.demoClothingManagement.model.ConnectionManager;
import com.codegym.demoClothingManagement.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {

    Connection connection = ConnectionManager.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    String sql = null;
    ResultSet resultSet;

    @Override
    public void createProduct(Product product) {
        sql = "insert into product (product_name, description, amount, sell_price, cost, id_type, id_species, id_producer)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getSellPrice());
            preparedStatement.setString(5, product.getCost());
            preparedStatement.setInt(6, product.getIdType());
            preparedStatement.setInt(7, product.getIdSpecies());
            preparedStatement.setInt(8, product.getIdProducer());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int idProduct) {
        Product product = null;
        sql = "select * from product where id_product = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduct);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("amount");
                String sellPrice = resultSet.getString("sell_price");
                String cost = resultSet.getString("cost");
                int idType = resultSet.getInt("id_type");
                int idSpecies = resultSet.getInt("id_species");
                int idProducer = resultSet.getInt("id_producer");

                product = new Product(idProduct, productName, description, amount, sellPrice, cost,
                        idType, idSpecies, idProducer);

                resultSet.close();
                preparedStatement.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        sql = "select * from product";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("id_product");
                String productName = resultSet.getString("product_name");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("amount");
                String sellPrice = resultSet.getString("sell_price");
                String cost = resultSet.getString("cost");
                int idType = resultSet.getInt("id_type");
                int idSpecies = resultSet.getInt("id_species");
                int idProducer = resultSet.getInt("id_producer");

                Product product = new Product(idProduct, productName, description, amount, sellPrice, cost,
                        idType, idSpecies, idProducer);

                listProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProducts;
    }

    @Override
    public void updateProduct(int idProduct, Product product) {
        sql = "update product set product_name = ?, description = ?, amount = ?, sell_price = ?, cost = ?, " +
                "id_type = ?, id_species = ?, id_producer = ? where id_product = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getSellPrice());
            preparedStatement.setString(5, product.getCost());
            preparedStatement.setInt(6, product.getIdType());
            preparedStatement.setInt(7, product.getIdSpecies());
            preparedStatement.setInt(8, product.getIdProducer());
            preparedStatement.setInt(9, product.getIdProduct());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Product product) {
        sql = "delete from product where id_product = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getIdProduct());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
