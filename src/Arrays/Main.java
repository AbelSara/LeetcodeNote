package Arrays;

/**
 * Created by zhh on 2019/9/18.
 */
public class Main {
    public static void main(String[] args) {
        PlusOne plusOne=new PlusOne();
        int[] array=new int[]{1,2,3};
        array=plusOne.plusOne(array);
        for(int num:array){
            System.out.println(num);
        }
    }
}
