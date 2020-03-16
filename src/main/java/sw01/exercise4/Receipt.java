/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw01.exercise4;

import java.util.*;

/**
 *
 * @author yannk
 */
public class Receipt {
    public List<Item> Items;
    
    public Receipt() {
        this.Items = new ArrayList<Item>();
    }
    
    public void addItem(Product product) {
        addItem(product, 1);
    }
    
    public void addItem(Product product, int amount) {
        this.Items.add(new Item(product, amount));
    }
    
    public int getNumberOfItems() {
        int numberOfItems = 0;
        // no real linq available
        for (Item item : this.Items) {
            numberOfItems += item.Amount;
        }
        return numberOfItems;
    }
    
    public int getTotalPriceInCentime() {
        int totalPriceInCentime = 0;
        for (Item item : this.Items) {
            totalPriceInCentime += item.Product.getPriceInCentime();
        }
        return totalPriceInCentime;
    }
    
    public void print() {
        for (Item item : this.Items) {
            System.out.println(item.toString());
        }
        System.out.println(String.format("Total number of items: %d", this.getNumberOfItems()));
        System.out.println(String.format("Total price: %.2f Fr.", (this.getTotalPriceInCentime()/ 100.0)));
    }
}
