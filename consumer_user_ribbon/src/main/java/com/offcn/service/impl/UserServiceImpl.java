package com.offcn.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
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
    private RestTemplate restTemplate;

    @Override
    public User getUser(Long id) {
        System.out.println("========9000======feign====");
        return userDao.getUser(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "buyMovieFallbackMethod")
    public Map<String, Object> buyMovie(Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        User user = this.getUser(userId);

        Movie movie = restTemplate.getForObject("http://PROVIDERMOVIE/movie/getNewMovie", Movie.class);
        resultMap.put("user",user);
        resultMap.put("movie",movie);
        System.out.println("========9000======feign====");
        return resultMap;
    }


    public Map<String,Object> buyMovieFallbackMethod(Long userId){
        Map<String, Object> resultMap = new HashMap<>();
        User user = new User(-1L,"未知用户");
        Movie movie = new Movie(-100L,"无此电影");

        resultMap.put("user",user);
        resultMap.put("movie",movie);
        return resultMap;
    }
}
