# 冒泡排序

> 思路： 就跟泡泡一样，大的在最后面，小的在最前面
>
> 数组： [23,24,54,-324,2,1,1,98,1]
>
> 23与24比较，否 --> 24和54比较，否 --> 54与-324比较，是，交换位置， [23,24,**-324**,**54**,2,1,1,98,1] --> 54和2比较，是，交换位置，依次往下，最终[23,24,-324,2,1,1,54,198]，最后一个是最大的



```JAVA
//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,98,1};
        bubbleSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length -1 ; i++) { //冒泡的次数
            for (int j = 0; j < arr.length -1 - i; j++) {
                //真正的交换
                if (arr[j] > arr[j + 1] ){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            
        }
    }
}
//冒泡排序优化 -- 在某一次一次都没有交换元素，则说明已经是有序的了，就不需要接着往下了
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,98,1};
        bubbleSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }
    public static void bubbleSort(int[] arr){
        //在某一次一次都没有交换元素，则说明已经是有序的了，就不需要接着往下了
        boolean flag = true;
        for (int i = 0; i < arr.length -1 ; i++) { //冒泡的次数
            for (int j = 0; j < arr.length -1 - i; j++) { //真正的交换
                if (arr[j] > arr[j + 1] ){
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (flag){//能进来说明后面已经是有序的了
                return;
            }
            
        }
    }
}
```

# 选择排序

> 思路： 创建一个min变量保存最小数，minIndex记录最小下标位置，默认等于第一个，然后通过min与每个数对比，最终得到最小的数值放在min中，并记录这个时候的下标，放在minIndex中，依此类推，最后交换位置



```JAVA
/**
 * 选择排序
 * @author Tcgow
 * @Date 2024/4/19 15:53
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,98,1};
        selectSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length -1; i++) { //排序的次数，取不到最后一个数所以i < arr.length -1
            int min = arr[i];
            int minIndex = i;
            //j = i+1 是因为第一个是假设是最小，与第二个数比较，并且能取到数组的最后一个数，所以j < arr.length
            for (int j = i +1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if ( i != minIndex){
                //交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
```

# 插入排序

> 思路：从第二个元素开始，insertIndex记录下标，insertValue记录这个值，insertValue是不会变的，然后这个值依次与insertIndex前面的值比较，所以insertIndex--，前面的值大的就将这个值赋值到这个insertIndex下标里，注意insertValue是不会变的，然后一直比较。其实就是选择了一个数，这个数与前面的数比较，如果前面的数比这个数大就将这个数赋值到insertIndex下标，然后insertIndex--，直到前面的所有值比insertValue小就跳出循环了。
>
> 总结：拿一个数插入到数组（将这个数的前面的所有的值看作一个有序的数组，之所以有序是因为第一次就将第一个数和第二个数比较了），从小到大排序。
>
> PS：不用怕，正常的程序下前面的数组肯定是从小到大排序的，所以不会出现排序不对的情况，因为第一次i会从1开始，然后insertIndex--，就会和第一个数比较。



```java
/**
 * 插入排序
 * @author Tcgow
 * @Date 2024/4/19 16:26
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,98,1};
        insertSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i;
            while (insertIndex > 0 && insertValue < arr[insertIndex -1]){
                //insertIndex大于0，如果等于0，arr[insertIndex -1]会数组下标越界
                //进不来就说明前面的数字都比insertValue小
                arr[insertIndex] = arr[insertIndex -1];
                insertIndex --;
            }
            arr[insertIndex] = insertValue;
        }
    }
}

```

# 希尔排序

> 思路： 其实就是插入排序，因为插入排序是步长为1的希尔排序，只不过希尔排序会有多个步长，先通过这个把一些先排序了，最后再进行步长为1的希尔排序（既插入排序），就不需要像插入排序这样比较这么多次。

```JAVA
/**
 * 希尔排序
 * @author Tcgow
 * @Date 2024/4/19 17:52
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,98,1};
        shellSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }
    public static void shellSort(int[] arr){
        //步长
        for (int gap = arr.length/2; gap >0 ; gap /=2 ) {
            for (int i = gap; i < arr.length ; i++) {
                //插入式
                int insertIndex = i;
                int insertValue = arr[i];
                while (insertIndex-gap >=0 && insertValue < arr[insertIndex -gap]){
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
    }
}
```



# 快速排序

> 思路：选择一个数，一般这个数是最左边的数，无所谓的，然后用两个指针，左指针指向第一个数，右指针指向最后一个数，右指针的数比选择的数大，就右指针--，左指针的数比选择的数小就左指针++，这样最终会要么两个指针相等，要么就在隔壁，相等就将这个数与选择的数交换未知，在隔壁就将这两个数交换未知，这样可以得到指针右边的数比指针的大，左边数的比选择的数小，然后再次递归，左边递归，右边递归，最终完成排序。

```java
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
            if (l == r) {
                 // 两个指针重合
                int temp = arr[l];
                arr[l] = arr[left];
                arr[left] = temp;
            } else { 
                // 两个指针不重合
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
```

# 归并排序

> 思路：将一个无序的数组，不断的从中间拆分，最终得到一个个数，然后再向上合并
>
> 合并的思路是将左边的数组的第一个数和右边数组的第一个数比较，小的放到临时数组里，临时数组合并所有数后就放到原数组里。
>
> PS：不会覆盖原来的数组，比如左边的数组合并后长度为5，那么必定是前原来数组的前5个，只是顺序与原来的数组不一样，右边数组同理。



```java
/**
 * 归并排序
 *
 * @author Tcgow
 * @Date 2024/4/19 19:05
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23, 24, 54, -324, 2, 1, 1, 98, 1};
        int[] temp = new int[ints.length];//临时数组
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
        t = 0;//之前的t已经被污染，所以重新赋值
        int tempLeft = left;
        //覆盖原来数组的值
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
```

# 基数排序

>思路：将每个数按照个位，百位，千位等等分次排序，最高的数有多少位，循环多少次。准备一个`桶`，这个桶下标从0~9共10个，将计算得到的数放到桶里，某个桶可能有多个数，所以是个二维数组，然后依次取出放到原数组里就好。

```java
/**
 * 基数排序
 *
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
                //得到相应的位数
                int value = arr[j]/(int)Math.pow(10,i) % 10;
                //因为是二维数组，假设是7，bucket[7][bucketElementCounts[7]]，一开始bucketElementCounts[7] = 0，即bucket[7][0]。
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

```

