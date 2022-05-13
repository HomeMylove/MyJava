package com.neta.myenum.enumstart;

@SuppressWarnings({"all"})
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SPRING);
    }
}

@Deprecated
enum Season {
    SPRING("Spring", "warm"), SUMMER("Summer", "hot"),
    AUTUMN("Autumn", "cool"), WINTER("Winter", "cold");
    private String name;
    private String feeling;

    Season(String name, String feeling) {
        this.name = name;
        this.feeling = feeling;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", feeling='" + feeling + '\'' +
                '}';
    }
}
