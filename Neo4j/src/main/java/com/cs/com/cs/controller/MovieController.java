package com.cs.com.cs.controller;

import com.cs.domain.Movie;
import com.cs.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping(value = "/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/index.html")
    public String index(){return "movie/index";}

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Movie index1(@PathVariable String title){
        Movie movie = movieRepository.findByTitle(title);
        return movie;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Movie index2(@PathVariable Long id){
        Movie movie = null;
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            movie = optionalMovie.get();
        }else{
            movie = null;
        }
        return movie;
    }
}
