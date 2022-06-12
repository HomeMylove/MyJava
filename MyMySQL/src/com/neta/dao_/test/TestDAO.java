package com.neta.dao_.test;

import com.neta.dao_.dao.ActorDAO.ActorDAO;
import com.neta.dao_.domain.Actor;

import java.util.List;

public class TestDAO {
    public static void main(String[] args) {

        ActorDAO actorDAO = new ActorDAO();

        List<Actor> actors = actorDAO.queryMulti("SELECT * FROM actor WHERE id > ?", Actor.class, 1);

        for (Actor actor : actors) {
            System.out.println(actor);
        }
    }
}
