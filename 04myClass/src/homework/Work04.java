package homework;

public class Work04 {
    public static void main(String[] args) {
        Employee employee1  = new Employee("Yae","male",500);
        Employee employee2 = new Employee("ceo",1000.0);
    }
}


class Employee{
    String name;
    String gender;
    int age;
    String position;
    double salary;

    public Employee(String name,String gender,int age,String position,double salary){
        this(name,gender,age);
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name,String gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String position,double salary){
        this.position = position;
        this.salary = salary;
    }

    public void showInfo(){
        System.out.println("名字:"+this.name);
        System.out.println("性别:"+this.gender);
        System.out.println("年龄:"+this.age);
        System.out.println("职位:"+this.position);
        System.out.println("薪水:"+this.salary);
    }
}
