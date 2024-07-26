import java.util.ArrayList;
import java.util.List;
//leetcode.com/problems/nested-list-weight-sum-ii/description
class NestedListWeightSumII {

    public class NestedInteger{
        private Integer singleInteger;
        private List<NestedInteger> nestedList;
        public NestedInteger(){
            this.nestedList = new ArrayList<>();
        }
        public NestedInteger(int val){
            this.singleInteger = val;

        }
        public boolean isInteger(){
            return singleInteger != null;
        }

        public int getInteger(){
            return singleInteger;
        }

        public void setInteger(int singleInteger){
            this.singleInteger = singleInteger;
            this.nestedList = null;
        }

        public List<NestedInteger> getNestedList() {
            if(this.isInteger()) return new ArrayList<>();
            return nestedList;
        }
    }

    public int DepthSumInverse(List<NestedInteger> nestedList){
        int depth = maxDepth(nestedList);
        return dfs(nestedList, depth);
    }

    public int maxDepth(List<NestedInteger> nestedIntegers){
        int depth = 1;
        if(nestedIntegers == null){
            return 0;
        }
        for(NestedInteger i : nestedIntegers){
            if(i.isInteger()){
                depth = 1;
            } else{
                depth = Math.max(depth, 1 + maxDepth(i.getNestedList()));
            }
        }
        return depth;
    }

    public int dfs(List<NestedInteger> nestedIntegers, int depth){
        int depthSum = 0;
        for(NestedInteger i : nestedIntegers) {
            if(i.isInteger()){
                depthSum += i.getInteger() * depth;
            }else{
                depthSum += dfs(i.getNestedList(), depth - 1);
            }
        }
        return depthSum;
    }


}


