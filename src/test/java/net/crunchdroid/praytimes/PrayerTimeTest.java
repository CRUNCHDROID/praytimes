package net.crunchdroid.praytimes;

import org.junit.Test;

import java.util.*;

import static net.crunchdroid.praytimes.StandardMethod.CFCM;
import static net.crunchdroid.praytimes.StandardMethod.UOIF;

/**
 * @author CrunchDroid
 */
public class PrayerTimeTest {

    @Test
    public void showPrayerTime() throws Exception {
        System.out.println("=== PRAYER TIME ===");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.JUNE, 23);

        Date date = calendar.getTime();
//        date = new Date();

        Method method = Method.fromStandard(UOIF);
//        method.addOffsetMinutes(-5, 0, 1, 0, 0, 12);

        // Initialize
        Prayer calculator = new Prayer()
                .setMethod(method)
                .setLocation(48.866669, 2.33333, 0) // PARIS
//                .setLocation(50.629086, 3.059519, 0) // LILLE
//                .setLocation(45.762964, 4.835120, 0) // LYON
//                .setLocation(43.295299, 5.375608, 0) // MARSEILLE
                .setDate(date, TimeZone.getDefault());


        TimeNames names = TimeNames.getInstance(Locale.getDefault());

        // Calculate and print each time
        for (Map.Entry<TimeType, PrayerTime> time : calculator.getPrayerTimes().entrySet()) {
            System.out.printf("%s\t%02d:%02d\n",
                    names.get(time.getKey()),
                    time.getValue().getHour(),
                    time.getValue().getMinute());
        }

        System.out.printf("%s:\t%s\n", names.get(TimeType.IMSAAK), calculator.getImsaak());
        System.out.printf("%s:\t%s\n", names.get(TimeType.NEXTFAJR), calculator.getNextDayFajr());
        System.out.println("Tomorrow Imsaak: " + calculator.getNextDayImsaak());
    }
}
