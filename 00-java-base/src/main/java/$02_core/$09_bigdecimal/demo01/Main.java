package $02_core.$09_bigdecimal.demo01;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489

        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0

        BigDecimal d11 = new BigDecimal("123.4500");
        BigDecimal d12 = d11.stripTrailingZeros();
        System.out.println(d11.scale()); // 4
        System.out.println(d12.scale()); // 2,因为去掉了00

        BigDecimal d13 = new BigDecimal("1234500");
        BigDecimal d14 = d13.stripTrailingZeros();
        System.out.println(d13.scale()); // 0
        System.out.println(d14.scale()); // -2
    }
}
