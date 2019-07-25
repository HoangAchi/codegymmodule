package com.codegym.demoClothingManagement.model;

public class Product {

    private int idProduct;
    private String productName;
    private String description;
    private int amount;
    private String sellPrice;
    private String cost;
    private int idType;
    private int idSpecies;
    private int idProducer;

    public Product(int idProduct, String productName, String description, int amount, String sellPrice,
                   String cost, int idType, int idSpecies, int idProducer) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.description = description;
        this.amount = amount;
        this.sellPrice = sellPrice;
        this.cost = cost;
        this.idType = idType;
        this.idSpecies = idSpecies;
        this.idProducer = idProducer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdSpecies() {
        return idSpecies;
    }

    public void setIdSpecies(int idSpecies) {
        this.idSpecies = idSpecies;
    }

    public int getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }
}
