package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTime;
    private static final HashMap<String, TimeZone> TimeZoneMap = new HashMap<String, TimeZone>();

    static {
        TimeZoneMap.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTime = dateAndTimeString;
    }

    public Date parse() {
        int year = getDateTime(0,4,"year",2000,2012);
        int month = getDateTime(5,7,"month",1,12);
        int date = getDateTime(8,10,"date",1,31);
        int hour = getDateTime(11,13,"hour",0,12);
        int minute = getDateTime(14,16,"minute",0,59);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public int getDateTime(int startSub,int endSub,String name,int rangeStart,int rangeEnd){
        int result = 0;
        int charactersLength = endSub - startSub;
        if (dateAndTime.substring(11, 12).equals("Z")) {
            if(name.equals("hour") || name.equals("minute")){
                return result;
            }
        }
        try {
            String resultString = dateAndTime.substring(startSub, endSub);
            result = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(name +"string is less than"+ charactersLength +"characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(name +"is not an integer");
        }
        if (result < rangeStart || result > rangeEnd)
            throw new IllegalArgumentException(name +"cannot be less than "+rangeStart+"or more than "+rangeEnd);
    }
}
