package start;

public class demo03 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {3,4,5},
                {3,48,9,0}
        };
        MyTools tools = new MyTools();

        tools.print2dArray(arr);

        System.out.println("=============");

        Person person = new Person();

        person.name = "mike";

        Person newPerson = tools.copyPerson(person);

        newPerson.age = 10;
        newPerson.name = "jack";

        System.out.println("person:age="+person.age+" name="+person.name);
        System.out.println("newPerson:age="+newPerson.age+" name="+newPerson.name);

    }
}


class MyTools{
    public void print2dArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 克隆人
    public Person copyPerson(Person p){
        Person person = new Person();
        person.name = p.name;
        person.age = p.age;
        return person;
    }
}
