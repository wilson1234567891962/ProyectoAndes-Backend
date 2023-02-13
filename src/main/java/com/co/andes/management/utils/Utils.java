package com.co.andes.management.utils;

import com.co.andes.management.domain.service.model.general.maps.ItemGoogle;

import java.text.DateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Utils {

    public static List<ItemGoogle> google = new ArrayList<>();

    public static String formaterCalendar(Calendar c) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static boolean isSameDateTime(Calendar cal1, Calendar cal2) {
        long daysBetween = ChronoUnit.DAYS.between(cal1.toInstant(), cal2.toInstant());
        // compare if is the same ERA, YEAR, DAY, HOUR, MINUTE and SECOND
        return daysBetween == 0;
    }

    public static boolean isSameWeek(Calendar cal1, Calendar cal2) {
        long daysBetween = ChronoUnit.DAYS.between(cal1.toInstant(), cal2.toInstant());
        // compare if is the same ERA, YEAR, DAY, HOUR, MINUTE and SECOND
        return daysBetween < 8 && daysBetween > -8;
    }

    public static boolean isSameMensual(Calendar cal1, Calendar cal2) {
        long daysBetween = ChronoUnit.DAYS.between(cal1.toInstant(), cal2.toInstant());
        // compare if is the same ERA, YEAR, DAY, HOUR, MINUTE and SECOND
        return daysBetween < 8 && daysBetween >= -31;
    }

    public static List<ItemGoogle> getGoogle() {
        return google;
    }

    public static void setGoogle(List<ItemGoogle> google) {
        Utils.google = google;
    }
}
