package myArray;

public class demo03 {
    public static void main(String[] args) {
        char[] chars = new char[26];
        for(int i = 0; i < chars.length; i++){
            chars[i] = (char) ('A' + i);
        }

        for (char aChar : chars) {
            System.out.print(aChar+" ");
        }
    }
}
