import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StickersToSpellWord {

    public static int MAXN = 401;

    public static String[] queue = new String[MAXN];

    public static int l, r;

    public static List<List<String>> graph = new ArrayList<>();

    static{
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
    }
    public static HashSet<String> visited = new HashSet<>(); 
    public int minStickers(String[] stickers, String target) {
        for (int i = 0; i < 26; i++) {
            graph.get(i).clear();
        }
        visited.clear();
        for(String str : stickers){
            str = sort(str);
            for (int i = 0; i < str.length(); i++) {
                if(i == 0 || str.charAt(i) != str.charAt(i - 1)){
                    graph.get(str.charAt(i) - 'a');
                }
            }
        }
        target = sort(target);
        visited.add(target);
        l = r = 0;
        int size;
        queue[r++] = target;
        int level = 1;
        while(l < r){
            size = r - l;
            for (int i = 0; i < size; i++) {
                String cur = queue[l++];
                for(String s : graph.get(cur.charAt(0) - 'a')) {
                    String next = next(cur, s);
                    if(next.equals("")){
                        return level;
                    } else if (!visited.contains(next)) {
                        visited.add(next);
                        queue[r++] = next;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private String sort(String target) {
        char[] s = target.toCharArray();
        Arrays.sort(s);
        return String.valueOf(s);
    }

    private String next(String cur, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < cur.length();) {
            if(j == s.length()){
                sb.append(cur.charAt(i++));
            }else{
                if (cur.charAt(i) < s.charAt(j)) {
                    sb.append(cur.charAt(i++));
                } else if (cur.charAt(i) > s.charAt(j)) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return sb.toString();
    }

}
