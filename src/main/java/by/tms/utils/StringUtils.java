package by.tms.utils;

public class StringUtils {

    public static void print(char[] inputArray) {
        for (char itm : inputArray) {
            System.out.print(itm);
        }
    }

    public static void println(char[] inputArray) {

        print(inputArray);
        System.out.print('\n');
    }

    public static boolean isBlank(char[] inputArray) {

        for (char itm : inputArray) {
            if (!Character.isWhitespace(itm)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRussian(char... inputArray) {

        for (char itm : inputArray) {
            if ((itm < 'А' || itm > 'я') && (itm != 'Ё' && itm != 'ё')) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(char[] mainString, char[] substring) {

        if (substring.length > mainString.length) {
            return false;
        }

        if (substring.length == 0) {
            return true;
        }

        if (mainString.length == 0) {
            return substring.length == 0;
        }

        for (int i = 0; i < mainString.length - 1; i++) {
            int match = 0;
            for (int j = 0; j < substring.length; j++) {
                if (mainString[i + j] != substring[j]) {
                    break;
                } else {
                    match++;
                }
            }
            if (match == substring.length) return true;
        }

        return false;
    }

    public static int parseInt(char[] inputArray) {

        int result = 0;
        int degree = inputArray.length - 1;

        for (char c : inputArray) {
            int tmp = c - '0';
            if (tmp < 0 || tmp > 9) {
                throw new IllegalArgumentException("Input string is not number!");
            }
            result += tmp * Math.pow(10, degree);
            degree--;
        }
        return result;
    }

}
