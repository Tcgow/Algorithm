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
            //插入式
            for (int i = gap; i < arr.length ; i++) {
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

// public static void main(String[] args) {
//         int[] ints = new int[]{23,24,54,-324,2,1,1,98,1};
//         bubbleSort(ints);
//         for (int anInt : ints) {
//             System.out.println(anInt + " ");
//         }
//     }
