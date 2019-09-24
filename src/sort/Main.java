package sort;


/**
 * Author: Honghan Zhu
 */
public class Main {
    public static void main(String[] args) {
        RelativeSortArray relativeSortArray=new RelativeSortArray();
        int arr1[]=new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int arr2[]=new int[]{2,1,4,3,9,6};
        arr1=relativeSortArray.relativeSortArray2(arr1,arr2);
        for(int i:arr1)
            System.out.println(i);
    }
}
