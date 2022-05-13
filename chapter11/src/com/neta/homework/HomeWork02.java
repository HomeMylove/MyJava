package com.neta.homework;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名");
        String name = scanner.next();
        System.out.println("输入密码");
        String password = scanner.next();
        System.out.println("输入邮箱");
        String email = scanner.next();

        try {
            register(name, password, email);
            System.out.println("登录成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("结束");
        }

    }

    public static void register(String name, String password, String email) throws Exception {
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new RuntimeException("用户名长度为2或3或4");
        }
        if (!(password.length() == 6 && isDigital(password))) {
            throw new RuntimeException("密码长度为6,且都为数字");
        }

        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");
        if (!(atIndex != -1 && dotIndex != -1 && atIndex < dotIndex)) {
            throw new RuntimeException("邮箱格式错误");
        }

    }

    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
