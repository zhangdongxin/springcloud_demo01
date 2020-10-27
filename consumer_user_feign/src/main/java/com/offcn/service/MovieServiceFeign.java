package com.offcn.service;

import com.offcn.pojo.Movie;
import com.offcn.service.impl.MovieServiceFeignExceptionHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "PROVIDERMOVIE",fallback = MovieServiceFeignExceptionHandler.class)
public interface MovieServiceFeign {

    @GetMapping("/movie/getNewMovie")
    public Movie getNewMovie();
}
