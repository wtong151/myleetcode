package leetcode;

import java.util.HashMap;

/**
 * 〈功能概述〉<br>
 *
 * @className: leetcode.add
 * @package: PACKAGE_NAME
 * @author: wangtong
 * @date: 1/5/21 3:26 PM
 **/

public class add {

    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = {0,0};
        for(int i =0;i<numbers.length;i++){
            if(map.get(numbers[i])!=null){
                int[] res = {map.get(numbers[i]),i};
                return res;
            }
            map.put(target-numbers[i],i);
        }
        return result;
    }

    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int target = 9;
        twoSum(numbers,target);
    }
}
