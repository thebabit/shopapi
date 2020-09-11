package com.example.shopapi.Repository;

import com.example.shopapi.Entity.AppUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



    @Repository
    public interface UserRepos extends CrudRepository<AppUser, Integer> {
        AppUser findById(int id);
        AppUser findByUsername(String name);

    }


