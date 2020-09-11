package com.example.shopapi.Repository;


import com.example.shopapi.Entity.Shopingcart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface CartRepos extends CrudRepository<Shopingcart, Integer> {
        Shopingcart findById(int id);
        Shopingcart findByUsername(String username);
        Shopingcart findByUsernameAndItemName(String username, String itemName);
        List<Shopingcart> findAllByUsername(String usename);

    }


