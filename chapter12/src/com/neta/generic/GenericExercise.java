package com.neta.generic;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        User yae = new User(100, 18, "Yae");
        User ei = new User(101, 500, "Ei");

        dao.save("100",yae);
        dao.save("101",ei);

        System.out.println(dao.get("101"));
        System.out.println(dao.get("100"));
        System.out.println(dao.list());
        dao.delete("101");
        dao.update("100",new User(100,100,"Kokomi"));
        System.out.println(dao.list());
    }
}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


class DAO<T>{
    private HashMap<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        if(!map.containsKey(id))
            throw new RuntimeException("没有");
        map.put(id,entity);
    }

    public List<T> list(){
        ArrayList<T> ts = new ArrayList<>();
        Collection<T> values = map.values();
        for (T value : values) {
            ts.add(value);
        }
        return ts;
    }

    public void delete(String id){
        if(!map.containsKey(id))
            throw new RuntimeException("没有");
        map.remove(id);
    }

}
