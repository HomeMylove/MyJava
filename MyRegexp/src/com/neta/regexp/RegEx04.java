package com.neta.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx04 {
    public static void main(String[] args) {

        String content = "https://www.bilibili.com/video/BV1fh411y7R8?p=894&vd_source=17062b62acee4b91ff70868d97afb2ca";

        /**
         * 思路
         * 1. 先确定协议 http:// | https://
         * 2. 域名 ([\\w-]+\\.)+[\\w-]+
         *      www.bilibili. + com
         * 3. 参数 (\/[\w-?=&/%.#]*)? 可能有也可能没有
         */

        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?";

        Pattern compile = Pattern.compile(regStr);


        Matcher matcher = compile.matcher(content);

        while (matcher.find())
            System.out.println(matcher.group(0));


    }
}
