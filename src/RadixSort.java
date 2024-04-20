/**
 * 基数排序
 * @author Tcgow
 * @Date 2024/4/19 22:28
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23, 24, 54, 324, 2, 1, 1, 98, 1};
        radixSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length - 1];
        int[] bucketElementCounts = new int[10];// 每个桶的个数

        // 获取最大值
        int max = arr[0];
        for (int k : arr) {
            if (max < k)
                max = k;
        }
        //获得最高位数
        int maxCount = (max + "").length();
        for (int i = 0; i < maxCount; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 得到相应的位数
                int value = arr[j]/(int)Math.pow(10,i) % 10;
                // 因为是二维数组，假设是7，bucket[7][bucketElementCounts[7]]，一开始bucketElementCounts[7] = 0，即bucket[7][0]。
                // 然后下标为7的桶插入一个数，然后 bucketElementCounts[7] ++，所以 bucketElementCounts[7] = 1了，即bucket[7][1]。
                bucket[value][bucketElementCounts[value]] = arr[j];
                bucketElementCounts[value] ++;
            }
            // 从桶里取数
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                //如果桶的长度不为0
                if (bucketElementCounts[j] != 0){
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                bucketElementCounts[j] = 0;
            }
        }


    }
}
