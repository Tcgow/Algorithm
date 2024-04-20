/**
 * 快速排序
 *
 * @author Tcgow
 * @Date 2024/4/19 18:18
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23, 24, 54, -324, 2, 1, 1, 98, 1};
        quickSort(ints, 0, ints.length - 1);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 递归退出的条件
        if (left >= right) {
            return;
        }
        // 左指针
        int l = left;
        // 右指针
        int r = right;
        while (l < r) {
            // 判断右指针,[选择的数]小于等于最右边的数，右指针--，这样就变成倒数第二个数与[选择的数]比较，条件不满足的时候说明r指针最右边的所有数比[选择的数]大
            while (l < r && arr[left] <= arr[r])
                r--;
            // 判断左指针,[选择的数]大于等于最左边的数，左指针++，这样就变成第二个数与[选择的数]比较，条件不满足的时候说明l指针最左边的所有数比[选择的数]小
            while (l < r && arr[left] >= arr[l])
                l++;
            // 到这一步的时候，左边的数比选择的数小，右边的数比选择的数大
            // 两个指针重合
            if (l == r) {
                int temp = arr[l];
                arr[l] = arr[left];
                arr[left] = temp;
            } else { // 两个指针不重合
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        // 递归
        quickSort(arr, left, l - 1);
        quickSort(arr, r + 1, right);
    }
}
