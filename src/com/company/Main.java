package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        Scanner scanner=new Scanner(System.in);
        int a;
        int b;
        char znak = 0;
        int resultat;
        System.out.println("Eskertuu RIM sifrasy choh tamga menen jazylat jana 10go cheyin gana.");
        System.out.print("Amal jaz--->>> ");
        String Input = scanner.nextLine();
        char[] x = new char[10];
        for(int i=0;i<Input.length();i++){
            x[i]=Input.charAt(i);
            if(x[i]=='+'){
                znak='+';
            }
            if(x[i]=='-'){
                znak='-';
                }
            if(x[i]=='*'){
                znak='*';
                }
            if(x[i]=='/'){
                znak='/';
                }
            }
        String val=String.valueOf(x);
        String[]podstr=val.split("[+-/*]");
        String t1=podstr[0];
        String t2=podstr[1];
        String t3=t2.trim();
        a=rimskii(t1);
        b=rimskii(t3);
        if(a<0 && b<0){
            throw new MyException("Tuura emes san");
        }else {
      resultat=cal(a,b,znak);
      String resRim=convertaciya(resultat);
            System.out.println(t1+" "+znak+" "+t3+" = "+resRim);

    }
        a=Integer.parseInt(t1);
        b=Integer.parseInt(t3);
        resultat=cal(a,b,znak);
        if(a>10 && b>10){
            throw new MyException("Tuura emas san");}
        System.out.println(a+" "+znak+" "+b+" = "+resultat);
    }
    private static String convertaciya (int Arab) {
        String[] rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = rim[Arab];
        return s;
    }
    private static int rimskii (String rim) {
        try {
            if (rim.equals("I")) {
                return 1;
            } else if (rim.equals("II")) {
                return 2;
            } else if (rim.equals("III")) {
                return 3;
            } else if (rim.equals("IV")) {
                return 4;
            } else if (rim.equals("V")) {
                return 5;
            } else if (rim.equals("VI")) {
                return 6;
            } else if (rim.equals("VII")) {
                return 7;
            } else if (rim.equals("VIII")) {
                return 8;
            } else if (rim.equals("IX")) {
                return 9;
            } else if (rim.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Tuura emes san");
        }
        return -1;
    }
    public static int cal (int a, int b, char znak) throws MyException {
        int result = 0;
        switch (znak) {
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                try {
                    result = a/b;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Tuura emes san");

                    break;
                }
                break;
            default:
                throw new MyException("Mynday znak jok");
        }
        return result;
    }

}


/*Калькулятор" деген консолдук программа түзүңүз. Программа колдонуучу консолдон киргизген арифметикалык амалдарды окуп,
алардын аткарылышынын жыйынтыгын консолго чыгарып турушу керек.

        Талаптар:
        1) Калькулятор эки сан менен кошуу, кемитүү, көбөйтүү жана бөлүү амалдарын аткара алат: a+b, a-b, a*b, a/b.
        Маалыматтар бир сапта берилиши керек! Ар бир сан жана арифметикалык операция жаңы сапта берилсе, андай чечимдер жараксыз деп эсептелет.
        2) Калькулятор араб (1,2,3,4,5 ...) жана Рим (I, II, III, IV, V ...) сандары менен да иштей алат.
        3) Калькулятор 1ден 10го чейинки сандарды кабыл алышы керек. Чыгууда сандар көлөмү боюнча чектелбейт жана ар
        кандай болушу мүмкүн. Мисалы 10+10=20 же 10*10=100
        4) Калькулятор бүтүн сандар менен гана иштей алат.
        5) Калькулятор бир эле учурда араб же рим цифралары менен гана иштей алат, колдонуучу 3+II сыяктуу сапты бергенде, exception ыргытылышы керек.
        6) Рим сандарын киргизүүдө жооп рим цифралары менен көрсөтүлүшү керек, араб сандарын киргизүүдө жооп араб цифралары менен көрсөтүлүшү керек.
        7) Колдонуучу туура эмес сандарды киргизгенде, exception ыргытылышы керек.
        8) Колдонуучу жогорудагы арифметикалык амалдардын бирине дал келбеген операторду киргизгенде exception ыргытылышы керек.*/

