package lesson14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateExcersie {
    public static void main(String[] args) {
        ZoneId vnZone = ZoneId.of("Asia/Ho_Chi_Minh");

        LocalDate date = LocalDate.of(2026, 11, 2);
        LocalTime time = LocalTime.of(21, 49, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        ZonedDateTime zoned = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Ho_Chi_Minh"));

        System.out.println("LocalDate     : " + date);
        System.out.println("LocalTime     : " + time);
        System.out.println("LocalDateTime : " + dateTime);
        System.out.println("ZonedDateTime : " + zoned);

        LocalDate secondDay = LocalDate.of(2000, 02, 20);
        LocalDate firstDay = LocalDate.of(1992, 06, 27);

        long days = ChronoUnit.DAYS.between(firstDay, secondDay);
        System.out.println(days);

        // Time convert
        ZonedDateTime vnTime = ZonedDateTime.of(2026, 11, 2, 21, 20, 20, 0, vnZone);
        ZonedDateTime utcTime = vnTime.withZoneSameInstant(ZoneOffset.UTC);
        System.out.println("Giờ VN : " + vnTime);
        System.out.println("-> UTC : " + utcTime);


        ZonedDateTime backToVn = utcTime.withZoneSameInstant(vnZone);
        System.out.println("UTC    : " + utcTime);
        System.out.println("-> VN  : " + backToVn);

    }

}
