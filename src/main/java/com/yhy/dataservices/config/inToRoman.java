package com.yhy.dataservices.config;

class inToRoman {
    //贪心法求解
    public static String inToRoman(int num){
        //1.列举所有可能的情况
        int []nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        //2.数组起始下标，最后结果
        int index=0;
        StringBuilder stringBuilder=new StringBuilder();
        //3.从大到小开始，寻找包含在num内的罗马字符
        while(index<13){
            while(num>=nums[index]){
                stringBuilder.append(romans[index]);
                num-=nums[index];
            }
            index++;
        }
        //最后返回结果
        return stringBuilder.toString();
    }

    public static void main(String[]args){
        System.out.println(inToRoman(1994));
    }

}
