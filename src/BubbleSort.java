/**
 * 冒泡排序
 * @author Tcgow
 * @Date 2024/4/19 15:28
 *
 */
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
            //在某一次一次都没有交换元素，则说明已经是有序的了，就不需要接着往下了
            boolean flag = true;
            for (int j = 0; j < arr.length -1 - i; j++) { //真正的交换
                if (arr[j] > arr[j + 1] ){
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (flag){
                return;
            }
            
        }
    }
}
