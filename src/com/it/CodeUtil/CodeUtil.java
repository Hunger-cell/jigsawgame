package com.it.CodeUtil;

import com.it.domain.User;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        //创建一个集合
        ArrayList< Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));//a~z
            list.add((char)('A' + i));//A~Z
        }
        //打印集合
        //System.out.println(list);
        String result ="";
        //从集合里面随机获取4个字符
        Random r =new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(52);
            char c = list.get(index);
            result = result + c;
        }
        //再后面拼接随机数字0~9
        int number = r.nextInt(10);
        result = number + result;
        //创建一个数组来存字符串
        char[] chars = result.toCharArray();
        //因为时4个字母和一个数字所以只要哪一个随机的字母与数字交换位置
        int index1 = r.nextInt(chars.length);
        char temp = chars[4];
        chars[4] = chars[index1];
        chars[index1] = temp;

        String code = new String(chars);
        return code;
    }
}
