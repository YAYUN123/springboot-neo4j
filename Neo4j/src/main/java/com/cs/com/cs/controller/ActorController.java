package com.cs.com.cs.controller;

import com.cs.domain.Actor;
import com.cs.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/actor")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Actor index(@PathVariable String name){
        Actor actor = actorRepository.findByName(name);
        return actor;
    }
}
