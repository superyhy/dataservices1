package com.yhy.dataservices.config;

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] s){
        if(s.length==0) return "";
        //从第一个字符串开始遍历
        for(int i=0;i<s[0].length();i++){
            char c=s[0].charAt(i);
            //遍历字符串数组，查找匹配字符串头，不匹配直接返回结果
            for(int j=1;j<s.length;j++){
                if(i==s[j].length()||s[j].charAt(i)!=c){
                    return s[0].substring(0,i);
                }
            }
        }

        return s[0];
    }

    public static void main(String[]args){
        String [] s={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
}
