package myconstructor;

public class demo01 {
    public static void main(String[] args) {
        Person person1 = new Person();
//        Person person2 = new Person("Yea",10);

        System.out.println("person1 no hashcode is "+person1.hashCode());
        person1.show();
    }
}


class Person{
    String name;
    int age;

    public Person() {
        this("Mike",12);
        System.out.println("构造器1被调用了");
    }

    public Person(String name, int age) {
        System.out.println("构造器2被调用了");
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println("my hashcode is "+this.hashCode());
    }
}
