package leetcode;

import java.util.Arrays;

public class sort {
   public static void main(String[] args){
      int[] source = {6,1,2,7,9,3,4,5,10,8};
      quickSort(source,0,9);
   }


   public static void quickSort(int[] source, int a,int b){

      if(a>b) {return;}

      int le = a;
      int ri = b;
      //基准数据，一般取起始数据
      int x = source[le];
      System.out.print(x);
      while (le<ri){
         //右侧循环递减，直到le和ri 相遇，或者出现小于基准的值
         while(le<ri && source[ri]>x){
             ri--;
         }
         if(le < ri){
            source[le] = source[ri];
            le++;
         }

         //左侧循环递增，直到出现大于基准数的值
         while(le<ri && source[le]<x){
             le++;
         }
         if(le < ri){
            source[ri] = source[le];
            ri--;
         }
      }
      //将基准点移动到中间位置
      source[le] = x;
      System.out.println(Arrays.toString(source));

      //递归调用
      quickSort(source, a, le-1);
      quickSort(source, le+1,b);

   }

}
