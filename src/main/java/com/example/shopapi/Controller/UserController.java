package com.example.shopapi.Controller;
import com.example.shopapi.Entity.AppUser;
import com.example.shopapi.Entity.Items;
import com.example.shopapi.Entity.Shopingcart;
import com.example.shopapi.Service.CartService;
import com.example.shopapi.Service.ItemService;
import com.example.shopapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {

    private ItemService itemService;
    private UserService userService;
    private CartService cartService;


    @Autowired
    public UserController(ItemService itemService, UserService userService, CartService cartService) {
        this.itemService = itemService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser addNewUser(@RequestBody  AppUser user) {
        return userService.addUser(user);
    }


    @GetMapping("/user")
    public List<AppUser> getAllUser() {
        return userService.getall();
    }

    @PostMapping(value = "/buy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String buyItems(@RequestBody Shopingcart cart) {



        Items updatedItem = itemService.findByItemName(cart.getItemName());
        AppUser user = userService.findByUserName(cart.getUsername());
        Shopingcart updatedCart = cartService.findByUsernameAndItemName(cart.getUsername(),cart.getItemName());
        if( user != null && updatedItem != null){
            if(updatedCart == null){
                int newItemQuantity = updatedItem.getItemQuantity() - cart.getQuantity();
                if ( newItemQuantity >= 0){
                    updatedItem.setItemQuantity(newItemQuantity);

                    cartService.update(cart);
                    itemService.update(updatedItem);
                    return  "transaction done, check your cart";
                }
                else{
                    return "out of stock";
                }


            }
            else {

                int newCartQuantity = updatedCart.getQuantity() + cart.getQuantity();
                int newItemQuantity = updatedItem.getItemQuantity() - cart.getQuantity();
                if(newItemQuantity >= 0){
                    updatedCart.setQuantity(newCartQuantity);
                    updatedItem.setItemQuantity(newItemQuantity);

                    cartService.update(updatedCart);
                    itemService.update(updatedItem);
                    return  "transaction done, check your cart";

                }else {
                    return "out of stock";
                }


            }
        }
        else {
            return "wrong items name or user name ";
        }


    }

    @PostMapping(value = "/usercart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shopingcart> showCart (@RequestBody AppUser user) {
        return cartService.getallByUsername(user.getUsername());
    }


}
