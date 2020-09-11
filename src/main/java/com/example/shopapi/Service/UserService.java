package com.example.shopapi.Service;


import com.example.shopapi.Entity.AppUser;
import com.example.shopapi.Repository.UserRepos;
import com.example.shopapi.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepos UserRepo;

    @Autowired
    public UserService(UserRepos repo) {
        super();
        this.UserRepo = repo;
    }

    @Transactional(readOnly = true)
    public AppUser getUserById(int id) throws ResourceNotFoundException {
        return UserRepo.findById(id);
    }

    @Transactional
    public AppUser update(AppUser updatedUser) {
        return UserRepo.save(updatedUser);
    }


    @Transactional
    public AppUser addUser(AppUser newUser) {
        return UserRepo.save(newUser);
    }

    @Transactional(readOnly = true)
    public AppUser findByUserName(String name) throws ResourceNotFoundException{
        return UserRepo.findByUsername(name);
    }

    @Transactional(readOnly = true)
    public List<AppUser> getall() throws ResourceNotFoundException{
        Iterable<AppUser> e = UserRepo.findAll();
        List<AppUser> list = getListFromIterator(e);
        return list;
    }

    public static <T> List<T> getListFromIterator(Iterable<T> iterable)
    {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }


}
