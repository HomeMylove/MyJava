package com.neta.jdbc.datasource;

public class Actor {
    private int id;
    private String content;

    public Actor() {
    }

    public Actor(int id, String content) {
        this.id = id;
        this.content = content;
    }



    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
