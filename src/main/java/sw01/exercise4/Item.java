/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw01.exercise4;

/**
 *
 * @author yannk
 */
public class Item {
    public int Amount;
    public Product Product;
    
    public Item(Product product, int amount) {
        this.Product = product;
        this.Amount = amount;
    }
    
    public int GetPriceInCentime() {
        return this.Amount * this.Product.getPriceInCentime();
    }
    
    public String toString() {
        return String.format("Item:\n%s | amount: %d", this.Product.toString(), this.Amount);
    }
}
