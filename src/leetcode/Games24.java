package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * @className: Games24
 * @package: LeetCode
 * @author: wangtong
 * @date: 2022/1/10 9:42 am
 **/

public class Games24 {

    // 回溯 选择两个数,各种运算结果 作为一个数 放回原数组, 继续执行,直到数组只剩下一个数

    static final int TARGET = 24;
    static final double EPSILON = 0.001;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums){
        List<Double> list = new ArrayList<Double>();

        for(int num : nums){
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list){

        if(list.size()==0) { return  false; }
        if(list.size()==1){ return Math.abs(list.get(0)- TARGET)< EPSILON; }

        int size = list.size();

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(i!=j){
                    List<Double> list2 = new ArrayList<>();
                    for(int k=0;k<size;k++){
                        if(k!=i&&k!=j){
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
//                        if (k < 2 && i > j) {
//                            continue;
//                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }

                }
            }
        }

        return false;

    }

    public static void main(String[] s){

//        int[] nums = {1,2,1,2};
        int[] nums = {4,1,8,7};
        Games24 games24 = new Games24();
        System.out.println(games24.judgePoint24(nums));
    }


}
