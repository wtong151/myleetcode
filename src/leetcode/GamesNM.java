package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入 4 个 整数 n  判断能否经过(四则运算)生成 m <br>
 * 只考虑 + - % /
 *
 * @className: GamesNM
 * @package: leetcode
 * @author: wangtong
 * @date: 2022/1/10 1:56 pm
 **/

public class GamesNM {

    static final double EPSILON = 0.001;
    int target = 0;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judge(int n, int m){
        List<Double> list = new ArrayList<>();
        for(int i=0;i<4; i++){
            list.add((double)n);
        }
        target = m;
        return resolve(list);
    }

    public boolean resolve(List<Double> list){
        if(list.size()==0){ return  false;}
        if(list.size()==1){return Math.abs(list.get(0)-target)<EPSILON ; }

        int size = list.size();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i!=j){
                    List<Double> list2 = new ArrayList<>();
                    for (int k=0;k<size;k++){
                        if(k!=i&&k!=j){
                            list2.add(list.get(k));
                        }
                    }

                    for (int t=0; t<4; t++){
                        if(t == ADD){
                            list2.add(list.get(i) + list.get(j));
                        }else if(t == MULTIPLY){
                            list2.add(list.get(i) * list.get(j));
                        }else if(t == SUBTRACT){
                            list2.add(list.get(i) - list.get(j));
                        }else {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }

                        if(resolve(list2)){
                            return true;
                        }

                        list2.remove(list2.size()-1);
                    }
                }
            }
        }

        return false;
    }


    public static void main(String[] s){

        GamesNM games = new GamesNM();
        System.out.println(games.judge(1,4));
    }


}
