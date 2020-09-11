package com.example.shopapi.Service;


import com.example.shopapi.Entity.Items;
import com.example.shopapi.Repository.ItemsRepos;
import com.example.shopapi.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private ItemsRepos ItemRepo;

    @Autowired
    public ItemService(ItemsRepos repo) {
        super();
        this.ItemRepo = repo;
    }

    @Transactional(readOnly = true)
    public Items getItemsById(int id) throws ResourceNotFoundException {
        return ItemRepo.findByItemId(id);
    }

    @Transactional
    public Items update(Items updatedItem) {
        return ItemRepo.save(updatedItem);
    }


    @Transactional
    public Items addItems(Items newItems) {
        return ItemRepo.save(newItems);
    }

    @Transactional(readOnly = true)
    public Items findByItemName(String name) throws ResourceNotFoundException{
        return ItemRepo.findByItemName(name);
    }

    @Transactional(readOnly = true)
    public List<Items> getall() throws ResourceNotFoundException{
        Iterable<Items> e = ItemRepo.findAll();
        List<Items> list = getListFromIterator(e);
        return list;
    }

    public static <T> List<T> getListFromIterator(Iterable<T> iterable)
    {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }


}
