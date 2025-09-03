package easy;

public class Question13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        int sum = 0, previous = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = getValue(s.charAt(i));
            if (curr < previous) {
                sum -= curr;
            } else {
                sum += curr;
            }
            previous = curr;
        }
        return sum;
    }

    public static int getValue(char roman) {
        return switch (roman) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
