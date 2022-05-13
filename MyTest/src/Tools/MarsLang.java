package Tools;

import java.util.Scanner;

public class MarsLang {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("输入");

            String str = scanner.nextLine();

            Mars.changeLang(str,3);
        }

    }
}


class Mars{

    public static void changeLang(String str,int offset){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chars.length; i++){
            sb.append(Character.toChars(chars[i]+offset));
        }

        System.out.println(new String(sb));

    }

}
