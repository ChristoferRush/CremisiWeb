package com.astralticket.entity;

import org.springframework.stereotype.Component;

import javax.persistence.OneToOne;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Cart {

    private Long id;

    private Map<Long, CartItem> cartItemMap = new HashMap<>();

    private Order order;

    public Cart(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Long, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    /*
     * check if cart contains certain cart item
     */
    public boolean containsKey(Long key){
        Set<Long> keys = cartItemMap.keySet();
        return keys.contains(key);
    }

    /*
     * returns cart item from map by product id
     */
    public CartItem getCartItemById(Long id){
        return getCartItemMap().get(id);
    }

    /*
     * puts to cart map
     */
    public void putToCartMap(Long id, CartItem cartItem){
        cartItemMap.put(id, cartItem);
    }

    public void removeFromCartMap(Long id){
        cartItemMap.remove(id);
    }
}
