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
        for (int i = 0; i < arr.length -1; i++) { //排序的次数
            int min = arr[i];
            int minIndex = i;
            for (int j = i +1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if ( i != minIndex){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
