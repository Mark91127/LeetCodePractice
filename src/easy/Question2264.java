package easy;

public class Question2264 {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("42352338"));
        System.out.println(largestGoodInteger("2213"));
        System.out.println(largestGoodInteger2("6777133339"));
        System.out.println(largestGoodInteger2("2300019"));
        System.out.println(largestGoodInteger2("42352338"));
        System.out.println(largestGoodInteger2("2213"));
    }

    public static String largestGoodInteger(String num) {
        int same = 0;
        char former = 0;
        int biggest = 0;
        String greatest = "";
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == former) {
                same++;
                if (same == 2) {
                    if (greatest.isEmpty()) {
                        greatest = "0";
                    }
                    biggest = Math.max(Integer.parseInt(greatest), Integer.parseInt(String.format("%s%s%s", former, former, former)));
                    if (biggest == 0) {
                        greatest = String.format("%d%d%d", 0, 0, 0);
                        continue;
                    }
                    greatest = String.valueOf(biggest);
                }
            } else {
                same = 0;
                former = num.charAt(i);
            }
        }
        return greatest;
    }

    public static String largestGoodInteger2(String num) {
        String[] possibleAns = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
        for (String possibleAn : possibleAns) {
            if (num.contains(possibleAn))
                return possibleAn;
        }
        return "";
    }
}
