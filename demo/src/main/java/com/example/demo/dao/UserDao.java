package com.example.demo.dao;


import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDao {
    private static List<User> users=new ArrayList<>();
    private static int count=3;
    static {
        users.add(new User(1, "Jack", new Date()));
        users.add(new User(2, "Emma", new Date()));
        users.add(new User(3, "John", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){

        if(user.getId()==null){
          user.setId( ++count);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id){
        for(User user:users){
            if(user.getId()==id)
                return user;
        }

        return null;
    }

    public User delete(int id){

        Iterator<User> itr= users.iterator();
        while (itr.hasNext()) {

              User user=itr.next();

            if (user.getId() == id){
                itr.remove();
                return user;
            }

        }
        return null;
    }

}
