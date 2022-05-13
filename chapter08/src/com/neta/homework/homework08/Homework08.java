package com.neta.homework.homework08;

public class Homework08 {
    public static void main(String[] args) {
        Student klee = new Student("Klee", 10, '女', 1);
        Student qiqi = new Student("Qiqi", 500, '女', 123);
        Teacher yae = new Teacher("Yae", 300, '女', 200);
        Teacher ei = new Teacher("Ei", 510, '女', 480);
        Person[] arr = {klee, qiqi, yae, ei};

        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length -1-i;j++){
                if(arr[j].getAge()<arr[j+1].getAge()){
                    Person temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < arr.length;i++){
            work(arr[i]);
            System.out.println(arr[i].basicInfo());
        }



    }

    public static void work(Person p){
        if(p instanceof Teacher){
            ((Teacher) p).teach();
            System.out.println(p.play());
        }else if(p instanceof Student){
            ((Student) p).study();
            System.out.println(p.play());
        }else{
            System.out.println("错误的对象");
        }
    }
}
