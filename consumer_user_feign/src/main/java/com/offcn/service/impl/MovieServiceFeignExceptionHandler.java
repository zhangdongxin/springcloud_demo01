package com.offcn.service.impl;

import com.offcn.pojo.Movie;
import com.offcn.service.MovieServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceFeignExceptionHandler implements MovieServiceFeign {
    @Override
    public Movie getNewMovie() {
        return new Movie(-100L,"没有此电影");
    }
}
