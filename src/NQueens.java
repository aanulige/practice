import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        StringBuilder path = new StringBuilder();
        List<List<String>> ans = new ArrayList<>();
        f1(ans, n, path, 0);
        return ans;
    }

    public void f1(List<List<String>> ans, int n, StringBuilder sb, int i){
        if(i == n){
            List<String> cur = new ArrayList<>();
            cur.add(sb.toString());
            ans.add(cur);
        }

        if(check()){
            sb.append("Q");
        } else{
            sb.append(".");
        }
    }

    public boolean check(){
        return false;
    }
}
