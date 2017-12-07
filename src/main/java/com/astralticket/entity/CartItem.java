package com.astralticket.entity;

import org.springframework.stereotype.Component;

@Component
public class CartItem {

    private Integer amount;

    private Product product;

    private Cart cart;

    public CartItem(){}

    public CartItem(Integer amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /*
     * Increase amount of cart item
     */
    public void increaseAmount(Integer value){
        amount += value;
    }

    /*
     * Decrease amount of cart item
     */
    public void decreaseAmount(Integer value){
        amount -= value;
    }

}
