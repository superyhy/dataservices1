package com.yhy.dataservices.config;

import java.lang.reflect.Array;
import java.util.Arrays;

public class maopao {

    public void bubble(int []a){
         for(int i=0;i<a.length;i++) {
             for (int j = i; j < a.length; j++) {
                 if (a[i] > a[j]) {
                     int temp = a[i];
                     a[i] = a[j];
                     a[j] = temp;
                 }
             }
             System.out.println("第"+(i+1)+"轮排序后数组"+Arrays.toString(a));
         }
    }

}

class test{
    public static  void main(String[]args){
        int []a={12,4,3,1,4,2};
        maopao maopao=new maopao();
        maopao.bubble(a);
    }
}
