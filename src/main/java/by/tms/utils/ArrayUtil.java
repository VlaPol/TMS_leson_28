package by.tms.utils;

import java.util.Scanner;

public class ArrayUtil {

    public static char[] getCharArray() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toCharArray();
    }
}
