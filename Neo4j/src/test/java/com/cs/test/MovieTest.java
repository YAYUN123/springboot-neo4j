package com.cs.test;

import com.cs.config.Neo4jConfig;
import com.cs.domain.Actor;
import com.cs.domain.Movie;
import com.cs.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Neo4jConfig.class})
public class MovieTest {
    private static Logger logger = LoggerFactory.getLogger(MovieTest.class);

    @Autowired
    MovieRepository movieRepository;

    @Before
    public void initData() {
        Movie m1 = new Movie();
        m1.setTitle("The m1");
        m1.setYear("1999-03-04");

        Actor actor1 = new Actor();
        actor1.setName("fangjun");

        Actor actor2 = new Actor();
        actor2.setName("fangshuai");

        m1.addRole(actor1, "haha");
        m1.addRole(actor2, "heihei");
        movieRepository.save(m1);
    }

    @Test
    public void findByTitleTest(){
        String title = "The m1";
        Movie movie = movieRepository.findByTitle(title);
        movie.getTitle();
    }

}
