package $07_collection.$06_enum_map;

import java.time.DayOfWeek;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class) {{
            put(DayOfWeek.MONDAY, "星期一");
            put(DayOfWeek.TUESDAY, "星期二");
            put(DayOfWeek.WEDNESDAY, "星期三");
            put(DayOfWeek.THURSDAY, "星期四");
            put(DayOfWeek.FRIDAY, "星期五");
            put(DayOfWeek.SATURDAY, "星期六");
            put(DayOfWeek.SUNDAY, "星期日");
        }};

        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
    }
}