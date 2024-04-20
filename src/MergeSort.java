/**
 * 归并排序
 *
 * @author Tcgow
 * @Date 2024/4/19 19:05
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23, 24, 54, -324, 2, 1, 1, 98, 1};
        int[] temp = new int[ints.length];
        mergeSort(ints, 0, ints.length - 1, temp);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 拆分
            int mid = (left + right) / 2;
            // 左边
            mergeSort(arr, 0, mid, temp);
            // 右边
            mergeSort(arr, mid + 1, right, temp);
            //合
            merge(arr,left,right,mid,temp);
        }
    }

    // 合并的方法
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        // 剩下的部分直接加入到temp里
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

}
