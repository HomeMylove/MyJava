package com.neta.polyparameter;

public class PolyParameter {
    public static void main(String[] args) {
        Manager manager = new Manager("Mike",20000,30000);
        Staff staff = new Staff("Jack", 10000);
        System.out.println("manager薪资"+showEmployeeAnnual(manager));
        System.out.println("staff薪资"+showEmployeeAnnual(staff));
        testWork(manager);
        testWork(staff);
    }

    public  static  double showEmployeeAnnual(Employee e){
        return e.getAnnual();
    }

    public static void testWork(Employee e){
        if(e instanceof Staff){
            ((Staff) e).work();
        }else if(e instanceof Manager){
            ((Manager) e).manage();
        }else{
            System.out.println("错误的员工");
        }
    }
}


class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public double getAnnual(){
        return this.salary * 12;
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    public void manage(){
        System.out.println("我是经理，我管人");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + this.bonus * 12;
    }
}

class Staff extends Employee{
    public Staff(String name, double salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println("我是员工，我上班");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
