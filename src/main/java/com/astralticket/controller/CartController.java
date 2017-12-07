package com.astralticket.controller;

import com.astralticket.entity.Cart;
import com.astralticket.entity.CartItem;
import com.astralticket.entity.Product;
import com.astralticket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/list")
    public String printCart(HttpSession session, Model model) {
        try {
            Cart cart = (Cart) session.getAttribute("cart");
            Map<Long, CartItem> cartItemMap = cart.getCartItemMap();
            Collection<CartItem> values = cartItemMap.values();
            model.addAttribute("cartItems", values);
            return "cart";
        } catch (NullPointerException e) {
            return "redirect:/product/list";
        }
    }

    @RequestMapping("/add/{id}")
    public String addItemToCart(@PathVariable Long id, HttpSession session) {

        Cart cart = (Cart) session.getAttribute("cart");
        Product product = productRepository.findOne(id);
        CartItem cartItem = new CartItem(1, product);
        if (cart == null) {
            cart = new Cart();
            Map<Long, CartItem> cartItemMap = new HashMap<>();
            cartItemMap.put(id, cartItem);
            cart.setCartItemMap(cartItemMap);
            session.setAttribute("cart", cart);
        } else {
            if (cart.containsKey(id)) {
                return "redirect:/product/list";
            } else {
                Map<Long, CartItem> cartItemMap = cart.getCartItemMap();
                cartItemMap.put(id, cartItem);
                cart.setCartItemMap(cartItemMap);
                session.setAttribute("cart", cart);
            }
        }
        return "redirect:/product/list";
    }

    @RequestMapping("/increase/{id}")
    public String increaseAmountInCart(@PathVariable Long id, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        CartItem cartItem = cart.getCartItemById(id);
        cartItem.increaseAmount(1);
        cart.putToCartMap(id, cartItem);
        session.setAttribute("cart", cart);
        return "redirect:/cart/list";
    }

    @RequestMapping("/decrease/{id}")
    public String decreaseAmountInCart(@PathVariable Long id, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        CartItem cartItem = cart.getCartItemById(id);
        cartItem.decreaseAmount(1);
        cart.putToCartMap(id, cartItem);
        session.setAttribute("cart", cart);
        return"redirect:/cart/list";
    }

    @RequestMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeFromCartMap(id);
        return"redirect:/cart/list";
    }
}
