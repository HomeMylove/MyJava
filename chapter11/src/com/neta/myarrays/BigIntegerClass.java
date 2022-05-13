package com.neta.myarrays;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerClass {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("999999999999999999990");
        BigInteger bigInteger1 = new BigInteger("10");

        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add);

        BigDecimal bigDecimal = new BigDecimal("3.1415922222222222222222222");
        BigDecimal bigDecimal1 = new BigDecimal("3.14");
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));

    }
}
