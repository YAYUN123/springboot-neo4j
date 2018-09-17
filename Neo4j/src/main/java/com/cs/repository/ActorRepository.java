package com.cs.repository;

import com.cs.domain.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
    Actor findByBorn(@Param("born") int born);

    Actor findByName(@Param("name") String name);
}
