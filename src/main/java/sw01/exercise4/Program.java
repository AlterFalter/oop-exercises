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
public class Program {
    public static void main(String[] arg) {
        Product beef = new Product("Best Beef", 1050, ProductUnit.grams, 150);
        // 2 cups of yoghurt
        Product yoghurt = new Product("Chocolate yoghurt", 250, ProductUnit.NumberOfItems, 2);
        
        Receipt myReceipt = new Receipt();
        myReceipt.addItem(beef);
        myReceipt.addItem(yoghurt, 2);
        
        myReceipt.print();
    }
}
