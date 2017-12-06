package com.astralticket.controller;

import com.astralticket.entity.Cart;
import com.astralticket.entity.CartItem;
import com.astralticket.entity.Product;
import com.astralticket.repository.CartItemRepository;
import com.astralticket.repository.CartRepository;
import com.astralticket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @RequestMapping("/add/{id}")
    public String addItemToCart(@PathVariable Long id, HttpSession session){
        Product product = productRepository.findOne(id);
        CartItem cartItem = new CartItem(1, product);
        if (session.getAttribute("cart") == null){
            Cart cart = new Cart();
            session.setAttribute("cart", cart);
        }
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.getCartItemList().contains(cartItem)){
            cart.getCartItemList().remove(cartItem);
            cartItem.setAmount(cartItem.getAmount() + 1);
        }
        cart.getCartItemList().add(cartItem);
        return "redirect:/product/list";
    }
}
