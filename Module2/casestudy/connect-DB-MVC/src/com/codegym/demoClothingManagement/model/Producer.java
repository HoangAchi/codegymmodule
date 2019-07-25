package com.codegym.demoClothingManagement.model;

public class Producer {
    private int idProducer;
    private String producerName;

    public Producer(int idProducer, String producerName) {
        this.idProducer = idProducer;
        this.producerName = producerName;
    }

    public int getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
