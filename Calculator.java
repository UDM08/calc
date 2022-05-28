package com.company;

import static java.lang.Integer.parseInt;

public class Calculator {
    static StringBuilder sb1 = new StringBuilder();

    public static String summa(String a, String b) {

        return a.concat(b);
    }

    public static String div(String a, String b) {

        int i = parseInt(b), t = a.length();
        if (i > 10) {
            throw new IllegalArgumentException();
        }
        int c = t / i;
        int u = t - c;
        String r = a.substring(0, a.length() - u);
        return r;
    }

    public static String mult(String a, String b) {
        String str = a;
        int n = parseInt(b);

        for (int i = 0; i < n; i++) {
            sb1.append(str);
        }
        return str = sb1.toString();
    }

    public static String sub(String a, String b) {
        try {
            return a.substring(0, a.indexOf(b)) + a.substring(a.indexOf(b) + b.length());
        } catch (RuntimeException e) {
            System.out.println("Нет вхождения вычитаемой строки");
        }
        return a;
    }
}