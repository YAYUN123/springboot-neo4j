package com.cs.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.*;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type="ACTS_IN")
public class Role {
    @Id
    @GeneratedValue
    Long id;
    String role;
    @StartNode
    Actor actor;
    @EndNode
    Movie movie;

    public Role(){

    }

    public Role(Actor actor, Movie movie, String name){
        this.actor = actor;
        this.movie = movie;
        this.role = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
