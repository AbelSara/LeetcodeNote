package Greedy;


import java.util.Arrays;

/**
 * author:Honghan Zhu
 * leetcode:1029
 * Grade:easy
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int sum=0;
        int toA[][]=new int[costs.length/2][2];
        int toB[][]=new int[costs.length/2][2];
        for(int i=0;i<costs.length;i++){
            if(i<toA.length){
                toA[i]=costs[i];
            }else{
                toB[i-toB.length]=costs[i];
            }
        }
        for(int i=0;i<toA.length;i++){
            for(int j=0;j<toB.length;j++) {
                if(toA[i][1]+toB[j][0]<toA[i][0]+toB[j][1]){
                    int temp[]=toB[j];
                    toB[j]=toA[i];
                    toA[i]=temp;
                }
            }
        }
        for(int i=0;i<toA.length;i++) sum+=toA[i][0];
        for(int i=0;i<toB.length;i++) sum+=toB[i][1];
        return sum;
    }
    public int twoCitySchedCost2(int[][] costs){
        Arrays.sort(costs, (o1, o2) -> (o2[1]-o2[0])-(o1[1]-o1[0]));
        int sum=0;
        for(int i=0;i<costs.length;i++){
            if(i<costs.length/2){
                sum+=costs[i][0];
            }else{
                sum+=costs[i][1];
            }
        }
        return sum;
    }
}
