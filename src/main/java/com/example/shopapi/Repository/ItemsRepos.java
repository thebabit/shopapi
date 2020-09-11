package com.example.shopapi.Repository;

import com.example.shopapi.Entity.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemsRepos extends CrudRepository<Items, Integer> {

        Items findByItemId(int id);
        Items findByItemName(String ItemName);

}
