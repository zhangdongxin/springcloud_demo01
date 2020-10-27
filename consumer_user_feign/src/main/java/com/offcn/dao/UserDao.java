package com.offcn.dao;

import com.offcn.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public User getUser(Long id){
        return new User(id,"张三");
    }
}
