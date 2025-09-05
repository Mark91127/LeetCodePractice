package easy;

public class Question14 {
    public static void main(String[] args) {
        String[] a = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(a));
        System.out.println(longestCommonPrefix(new String[]{""}));
        String[] b = {"preheat", "oven", "prehistoric"};
        System.out.println(longestCommonPrefix(b));
    }

    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        if (first.isEmpty())
            return "";
        String ans = "";
        boolean checkAll = true;
        for (int i = 1; i <= first.length(); i++) {
            String check = first.substring(0, i);
            for (String str : strs) {
                if (str.isEmpty()) {
                    checkAll = false;
                    break;
                }
                if (!str.startsWith(check)) {
                    checkAll = false;
                    break;
                }
            }
            if (checkAll)
                ans = check;
        }
        return ans;
    }
}
