package com.offcn.dao;


import com.offcn.pojo.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {

    public Movie getNewMovie(){
        return new Movie(1L,"战狼");
    }
}
