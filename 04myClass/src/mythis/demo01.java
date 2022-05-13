package mythis;

import java.util.Objects;

public class demo01 {
    public static void main(String[] args) {
        Person yae = new Person("Yae", 500);
        Person person = new Person();
        System.out.println(yae.compareTo(person));
        person.name = "Yae";
        person.age = 500;
        System.out.println(yae.compareTo(person));
    }
}


class Person{
    String name;
    int age;
    public Person(){}
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public boolean compareTo(Person p){
        return this.name.equals(p.name) && this.age == p.age;
    }
}
