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
