/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw01.exercise4;

/**
 *
 * @author yannk
 */
public class Product {
    private String name;
    
    /// Centime = Schweizer Rappen
    private int priceInCentime;
    
    private ProductUnit productUnit;
    
    /// refers to product unit
    private int amount;
    
    public Product(String name, int priceInCentime, ProductUnit productUnit, int amount) {
        this.name = name;
        this.priceInCentime = priceInCentime;
        this.productUnit = productUnit;
        this.amount = amount;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPriceInCentime() {
        return this.priceInCentime;
    }
    
    public ProductUnit getProductUnit() {
        return this.productUnit;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public String toString() {
        return String.format("Product: %s costs %.2f Fr. for %d %b", this.name, this.priceInCentime/100.0, this.amount, this.productUnit);
    }
}
