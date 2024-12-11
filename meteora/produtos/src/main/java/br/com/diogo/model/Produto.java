package br.com.diogo.model;


import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class Produto {

    @CsvBindByName(column = "ProductID", required = true)
    private int id;
    @CsvBindByName(column = "ProductName", required = true)
    private String name;
    @CsvBindByName(column = "Price", required = true)
    private BigDecimal price;
    @CsvBindByName(column = "Description", required = true)
    private String description;
    @CsvBindByName(column = "Category", required = true)
    private String category;

    public Produto(String name, BigDecimal price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
