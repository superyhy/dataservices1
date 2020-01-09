package com.yhy.dataservices.config;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {
    public static Integer romanToInt(String s){
        Map<String,Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("C",100);
        map.put("XC",90);
        map.put("D",500);
        map.put("CD",400);
        map.put("M",1000);
        map.put("CM",900);

        int ans=0;
        for(int i=0;i<s.length();){
            //1.使用subString取两位子串，如map中存在
            if(i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                ans+=map.get(s.substring(i,i+2));
                i+=2;
            }
            //2. 取一位子串
            else{
                ans+=map.get(s.substring(i,i+1));
                i++;
            }
        }
        return ans;

    }

    public static void main(String[]args){
        System.out.println(romanToInt("MMMXLV"));
    }
}
