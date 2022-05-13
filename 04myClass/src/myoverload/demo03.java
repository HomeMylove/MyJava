package myoverload;

public class demo03 {
    public static void main(String[] args) {
        Method method = new Method();
        method.showScore("Yae",98.1,78,56);
        method.showScore("Ei",56,34,12);

        Yae yae = new Yae();
        yae.sayHi();

        Ei ei = new Ei();
        ei.call();
        ei.hug(yae);
    }
}

class Yae{
    String name = "Yae";
    public void sayHi(){
        String name = "Miko";
        System.out.println("My name is " + name);  // My name is Miko
    }
}

class Ei{
    public void call(){
        Yae yae = new Yae();
        System.out.println("I'm Ei, my friend is " + yae.name);
    }

    public void hug(Yae yae){
        System.out.println("I'm Ei, I want to hug "+ yae.name);
    }
}
