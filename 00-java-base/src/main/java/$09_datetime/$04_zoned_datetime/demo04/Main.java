package $09_datetime.$04_zoned_datetime.demo04;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        // 2019-09-15T13:00:00
        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
        System.out.println("原始时间(时区:null):" + bj);
        LocalDateTime bj2 = bj.plusHours(h).plusMinutes(m);
        System.out.println("落地时间(时区:null):" + bj2);
        // 获取中国时区时间
        ZonedDateTime zsh = bj2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("落地时间(时区:中国):" + zsh);
        // 转换为美国时区时间
        ZonedDateTime zny = zsh.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("落地时间(时区:美国):" + zny);
        bj = zny.toLocalDateTime();
        System.out.println("落地时间(时区:null):" + bj);
        System.out.println("--------------------------------------------------------");
        return bj;
    }
}