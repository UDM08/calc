package com.company;

import java.util.Scanner;

public class Main {
    static String line;
    static String result;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение в одну строку, выделяя каждый аргумент двойными кавычками \"\" ");
        String string = scanner.nextLine();
        if (string.matches("\".*\".\\d*|\".*\"")) {
            line = string.replaceAll("\"", "");
            } else {
                System.out.println("Аргументы выражения должы быть выделены двойными кавычками.");
                throw new IllegalArgumentException();
            }
        try {
            char sign = checkSign(line);
            String[] part = line.split("[*/+-]");
            String num1 = part[0];
            String num2 = part[1];
            if (num1.length() >= 11) {
                limit(num1);
                throw new IllegalArgumentException();
            }
            if (num2.length() >= 11) {
                limit(num2);
                throw new IllegalArgumentException();
            }
            result = Main.calculator((part[0]), (part[1]), sign);

            if (result.length() <= 40)
                System.out.println("Output:" + "\n" + "\"" + result + "\" ");
            else {
                System.out.println("Output:" + "\n" + "\"" + result.substring(0, 41) + "(...)\"");
            }

        } catch (RuntimeException e) {
            System.out.println("Неверный формат");
        }
    }

    public static void limit(String Str) {
        System.out.println("Превышен лимит,в аргументе больше 10 символов");

    }

    public static String calculator(String num0, String num1, char operator) {
        String result;
        switch (operator) {
            case '+':
                result = Calculator.summa(num0, num1);
                break;
            case '-':
                result = Calculator.sub(num0, num1);
                break;
            case '*':
                result = Calculator.mult(num0, num1);
                break;
            case '/':
                result = Calculator.div(num0, num1);
                break;
            default:
                throw new IllegalArgumentException("Неверный знак");
        }
        return result;
    }

    static char checkSign(String line) {
        if (line.contains("+")) {
            return '+';
        } else if (line.contains("-")) {
            return '-';
        } else if (line.contains("*")) {
            return '*';
        } else if (line.contains("/")) {
            return '/';
        } else {
            System.out.println("Арифметический знак введен неверно.");
            throw new IllegalArgumentException();
        }
    }
}

