import java.util.Arrays;

public class kClosestPointsToOrigin {
    int first, last;
    public int[][] kClosestPointsToOrigin(int[][] points, int k){
        random_select(points, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void random_select(int[][] array, int l, int r){
        if(l > r){
            return;
        }
        int[] x = array[l + (int) (Math.random() * (r - l))];

        partition(array,l, r, x);
        int left = first;
        int right = last;
        random_select(array, l, left - 1);
        random_select(array, right + 1, r);
    }

    private void partition(int[][] array, int l, int r, int[] x) {
        int i = l;
        first = l;
        last = r;
        distance(x);
        while(i <= last){
            if(distance(array[i]) < distance(x)){
                swap(array, i++, first++);
            } else if (distance(array[i]) > distance(x)) {
                swap(array, i, last--);
            }else {
                i++;
            }
        }
    }

    private void swap(int[][] array, int a, int b) {
        int[] temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
