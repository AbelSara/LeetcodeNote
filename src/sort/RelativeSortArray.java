package sort;


import java.util.*;

/**
 * Author:Honghan Zhu
 * leetcode:39
 * Grade:easy
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> tempMap=new HashMap<>();
        for(int i:arr1){
            if(tempMap.containsKey(i)){
                tempMap.put(i,tempMap.get(i)+1);
            }else{
                tempMap.put(i,1);
            }
        }
        int j=0;
        for(int i=0;i<arr2.length;i++){
            while(tempMap.get(arr2[i])>0){
                arr1[j++]=arr2[i];
                tempMap.put(arr2[i],tempMap.get(arr2[i])-1);
            }
            tempMap.remove(arr2[i]);
        }
        List<Integer> tempList=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:tempMap.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                tempList.add(entry.getKey());
            }
        }
        Collections.sort(tempList);
        while(!tempList.isEmpty()){
            arr1[j++]=tempList.remove(0);
        }

        return arr1;
    }
    public int[] relativeSortArray2(int arr1[],int arr2[]){
        int result[]=new int[arr1.length];
        int map[]=new int[1001];
        for(int i=0;i<arr1.length;i++){
            map[arr1[i]]++;
        }
        int index=0;
        for(int i=0;i<arr2.length;i++){
            while(map[arr2[i]]>0){
                map[arr2[i]]--;
                result[index++]=arr2[i];
            }
        }
        for(int i=0;i<map.length;i++) {
            while(map[i]>0){
                map[i]--;
                result[index++]=i;
            }
        }
        return  result;
    }
}
