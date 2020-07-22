package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter a number");
        Scanner s=new Scanner(System.in);
       String x= s.nextLine();
       int rev=romanToInt(x);
        System.out.println("Number is  :"+rev);
    }

//        static int reverse(int x) {
//            int rev = 0;
//            while (x != 0) {
//                int pop = x % 10;
//                x /= 10;
//                if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//                if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//                rev = rev * 10 + pop;
//            }
//            return rev;
//        }
//static boolean isPalindrome(int x) {
//    int rev = 0;
//    if(x<0)
//        return false;
//    int y=x;
//    while (y != 0) {
//        int pop = y % 10;
//        y /= 10;
//        rev = rev * 10 + pop;
//    }
//    if(x==rev)
//    {
//        return true;
//    }
//    return false;
//
//}
    static int romanToInt(String s) {
        char[] array = s.toCharArray();
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            final char c = array[i];
            switch (c) {
                case 'M':
                    result += 1_000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (i < array.length - 1 && (array[i + 1] == 'M' || array[i + 1] == 'D'))
                        result -= 100;
                    else
                        result += 100;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (i < array.length - 1 && (array[i + 1] == 'C' || array[i + 1] == 'L'))
                        result -= 10;
                    else
                        result += 10;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if (i < array.length - 1 && (array[i + 1] == 'X' || array[i + 1] == 'V'))
                        result -= 1;
                    else
                        result += 1;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + c);
            }
        }
        return result;
    }

}
