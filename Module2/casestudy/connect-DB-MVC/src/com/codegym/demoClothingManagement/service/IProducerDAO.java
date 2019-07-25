package com.codegym.demoClothingManagement.service;

import com.codegym.demoClothingManagement.model.Producer;

import java.util.List;

public interface IProducerDAO {

    public void createProducer(Producer producer);

    public Producer getProducerById(int idProducer);

    public List<Producer> getAllProducers();

    public void updateProducer(int idProducer, Producer producer);

    public void deleteProducer(Producer producer);
}
