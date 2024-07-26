// 已知arr[l....r]范围上一定有x这个值
// 划分数组 <=x放左边，>x放右边，并且确保划分完成后<=x区域的最后一个数字是x
public class QuickSort {

    public static int first;
    public static int last;
    public void quickSort(int[] nums, int k, int l, int r){
        if(l >= r){
            return;
        }
        partition(nums, l, r, k);
        // 返回两个值，分别是 ==x 的左边界和右边界，用first和last记录， 调左右侧递归
        // 为了防止底层的递归过程覆盖全局变量
        // 这里用临时变量记录first、last
        int left = first;
        int right = last;
        quickSort(nums, k, l, left - 1);
        quickSort(nums, k, right + 1, r);
    }

    public void partition(int[] nums, int l, int r, int k){
        int i = l;
        first = l;
        last = r;
        while(i <= last){
            if(nums[i] < k){
                swap(nums, i++ , first++);
            } else if (nums[i] > k) {
                swap(nums, i, last--);
            } else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
