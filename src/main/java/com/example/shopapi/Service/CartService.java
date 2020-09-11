package com.example.shopapi.Service;


import com.example.shopapi.Entity.AppUser;
import com.example.shopapi.Entity.Items;
import com.example.shopapi.Entity.Shopingcart;
import com.example.shopapi.Repository.CartRepos;
import com.example.shopapi.Repository.ItemsRepos;
import com.example.shopapi.Repository.UserRepos;
import com.example.shopapi.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private CartRepos CartRepo;

    @Autowired
    public CartService(CartRepos repo) {
        super();
        this.CartRepo = repo;
    }

    @Transactional(readOnly = true)
    public Shopingcart getCartById(int id) throws ResourceNotFoundException {
        return CartRepo.findById(id);
    }

    @Transactional
    public Shopingcart update(Shopingcart updatedCart) {
        return CartRepo.save(updatedCart);
    }



    @Transactional
    public Shopingcart addItems(Shopingcart newCart) {
        return CartRepo.save(newCart);
    }

    @Transactional(readOnly = true)
    public Shopingcart findByUserName(String name) throws ResourceNotFoundException{
        return CartRepo.findByUsername(name);
    }

    @Transactional(readOnly = true)
    public Shopingcart findByUsernameAndItemName (String name,String itemname) throws ResourceNotFoundException{
        return CartRepo.findByUsernameAndItemName(name,itemname);
    }

    @Transactional
    public List<Shopingcart> getallByUsername (String name) throws ResourceNotFoundException{
        Iterable<Shopingcart> e = CartRepo.findAllByUsername(name);
        List<Shopingcart> list = getListFromIterator(e);
        return list;
    }

    @Transactional(readOnly = true)
    public List<Shopingcart> getall() throws ResourceNotFoundException{
        Iterable<Shopingcart> e = CartRepo.findAll();
        List<Shopingcart> list = getListFromIterator(e);
        return list;
    }

    public static <T> List<T> getListFromIterator(Iterable<T> iterable)
    {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }


}
