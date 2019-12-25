package kyu5.Merged_String_Checker;

public class StringMerger {

    public static boolean isMerge(String s, String part1, String part2) {
        if (part1.equals(part2) & !s.isEmpty()) return false;

        char[] keys = s.toCharArray();
        char[] val1 = part1.toCharArray();
        char[] val2 = part2.toCharArray();

        //通過遞增下標判斷順序
        int index1 = 0,index2 = 0;
        if(keys.length != val1.length + val2.length) return false;
        for (char key : keys) {
            if (index1 < val1.length && val1[index1] == key) index1++;
            if (index2 < val2.length && val2[index2] == key) index2++;
        }
        return keys.length == index1 + index2;
    }

    public static boolean best(String s, String part1, String part2) {
        if (part1.equals(part2) & !s.isEmpty()) return false;

        char[] ch = s.toCharArray();
        char[] p1 = part1.toCharArray();
        char[] p2 = part2.toCharArray();
        int l = ch.length, l1 = p1.length, l2 = p2.length;
        int n = 0, m = 0;
        if (l == (l1 + l2)){
            for (char c : ch) {
                if (n < l1 && c == p1[n]) n++;
                if (m < l2 && c == p2[m]) m++;
            }
            return l == n + m;

        } else return false;

    }

}