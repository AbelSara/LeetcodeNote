package Greedy;

/**
 * Created by zhh on 2019/9/22.
 */
public class Main {
    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        int result = twoCityScheduling.twoCitySchedCost(new int[][]{{518, 518}, {71, 971}, {121, 862}, {967, 607}, {138, 754}, {513, 337}, {499, 873}, {337, 387}, {647, 917}, {76, 417}});
        System.out.println(result);
    }
}
