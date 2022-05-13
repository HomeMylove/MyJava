package start;

public class demo01 {
    public static void main(String[] args) {
        Person p = new Person();
//        System.out.println(p.age);
//        System.out.println(p.name);
        p.name = "Yae";
        p.age = 18;
        System.out.println(p.age);
        System.out.println(p.name);
        System.out.println(p.sum(1,2));
    }
}

class Person{
    String name;
    int age;

    public int sum(int num1,int num2){
        return num1 + num2;
    }
}
