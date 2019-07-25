package com.codegym.demoClothingManagement.service;

import com.codegym.demoClothingManagement.model.ConnectionManager;
import com.codegym.demoClothingManagement.model.Producer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerDAOImlp implements IProducerDAO {

    Connection connection = ConnectionManager.getConnection();
    Statement statement;
    PreparedStatement preparedStatement;
    String sql;
    ResultSet resultSet;

    @Override
    public void createProducer(Producer producer) {
        sql = "insert into producer (name) values (?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producer.getProducerName());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Producer getProducerById(int idProducer) {
        Producer producer = null;
        sql = "select * from producer where id_Producer = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProducer);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String producerName = resultSet.getString("name");
                producer = new Producer(idProducer, producerName);

                resultSet.close();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producer;
    }

    @Override
    public List<Producer> getAllProducers() {
        List<Producer> listProducer = new ArrayList<>();
        sql = "select * from producer";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idProducer = resultSet.getInt("id_Producer");
                String producerName = resultSet.getString("name");
                Producer producer = new Producer(idProducer, producerName);
                listProducer.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProducer;
    }

    @Override
    public void updateProducer(int idProducer, Producer producer) {

    }

    @Override
    public void deleteProducer(Producer producer) {

    }
}
