package com.neta.mystringbuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
//        方式一
        StringBuffer stringBuffer = new StringBuffer();

//        String ==> StringBuffer
        String str = "Hello World";
        StringBuffer stringBuffer1 = new StringBuffer(str);
        StringBuffer append = stringBuffer1.append(str);
        System.out.println(append);

        String string = stringBuffer1.toString();

        String string2 = new String(stringBuffer);
    }
}
