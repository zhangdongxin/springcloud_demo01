package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import com.offcn.service.MovieServiceFeign;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MovieServiceFeign movieServiceFeign;

    @Override
    public User getUser(Long id) {
        System.out.println("========7000======feign====");
        return userDao.getUser(id);
    }

    @Override
    public Map<String, Object> buyMovie(Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        User user = this.getUser(userId);

        Movie movie = movieServiceFeign.getNewMovie();

        resultMap.put("user",user);
        resultMap.put("movie",movie);
        System.out.println("========7000======feign====");
        return resultMap;
    }
}
