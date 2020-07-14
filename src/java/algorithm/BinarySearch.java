package algorithm;
import java.util.Random;
/**
 * 二分查找，针对的必须是已经排好序的数组
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 2;
        int result = doSearch(arr, target);
        if (result == -1) {
            System.out.println("不存在");
        } else {
            System.out.println("存在");
        }
    }
    /**
     * 算法分析
     * 拿目标值跟数组中间值做比较
     * 如果大于目标值，left = pivot +1; 这句代码的意义就是把左侧的位置移动到 pivot的临近右侧位置，然后继续找中间值（left + right）/2；
     * 如果小于目标值，right = pivot - 1;  这句代码的意义就是把右侧的位置移动到 pivot 的临近左侧位置, 然后继续找中间值 （left + right）/2；
     * @param arr
     * @param target
     * @return
     */
    private static int doSearch(int[] arr, int target) {
        int pivot = 0;
        int left = 0;
        int right = arr[arr.length - 1];
        while (left <= right) {
            pivot = (int) Math.floor((left + right) / 2);
            if (arr[pivot] == target) {
                return pivot;
            } else if (target < arr[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }
}
