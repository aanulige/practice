public class UnionFind {
    public static int MAXN = 1000001;
    public static int[] father = new int[MAXN];
    public static int[] size = new int[MAXN];
    public static int[] stack = new int[MAXN];

    public int n;

    public void build(){
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }
    public int find(int a){
        int size = 0;
        while(a != father[a]){
            stack[size++] = a;
            a = father[a];
        }
        while(size > 0){
            father[stack[size--]] = a;
        }
        return a;

//        while(a != father[a]){
//            father[a] = find(father[a]);
//        }
//        return father[a];
    }

    public void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            if(size[fa] > size[fb]){
                size[fa] += size[fb];
                father[fb] = fa;
            } else{
                size[fb] += size[fa];
                father[fa] = fb;
            }
        }
    }

    public boolean isSameSet(int a, int b){
        return find(a) == find(b);
    }

    public static void main(String[] args) {

    }

}
