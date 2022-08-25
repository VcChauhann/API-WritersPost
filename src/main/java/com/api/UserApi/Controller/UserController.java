package com.api.UserApi.Controller;

import com.api.UserApi.Entities.User;
import com.api.UserApi.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepo repo;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public User addUserDetail(@RequestBody User user){
        user.setEmail(user.getEmail().toLowerCase());
        user.setCompany(user.getCompany().toLowerCase());
        user.setName(user.getName().toLowerCase());

        System.out.println(user);
        User user1 = repo.save(user);

        return user1;
    }

    @RequestMapping(value = "/getUser" , method = RequestMethod.POST)
    public User getUser(@RequestParam String emailId){

        List<User> userList = (List<User>) repo.findAll();

        for (User user: userList){
            if (user.getEmail().equals(emailId))
                return user;
        }
        return null;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public boolean deleteUser(@RequestParam String emailId){

        List<User> userList = (List<User>) repo.findAll();
        boolean deleted = false;
        for (User user: userList){
            if (user.getEmail().equals(emailId)){
                repo.deleteById(user.getId());
                return true;
            }
        }
        return false;

    }

    @RequestMapping("/allUsers")
    public List<User> showAllUser(){
        List<User> userList = (List<User>) repo.findAll();
        System.out.println(userList);
        return userList;
    }

}
