// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Date.java

package classes;


public class Date
{

    public Date(java.sql.Date date)
    {
        String dateString = date.toString();
        int i = 0;
        int j = 0;
        while(dateString.charAt(i++) != '-') ;
        year = Integer.parseInt(dateString.substring(j, i - 1));
        j = i;
        while(dateString.charAt(i++) != '-') ;
        month = Integer.parseInt(dateString.substring(j, --i));
        day = Integer.parseInt(dateString.substring(++i, dateString.length()));
        monthS = MONTHS[month - 1];
    }

    Date(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        monthS = MONTHS[month - 1];
    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public String getMonthS()
    {
        return monthS;
    }

    public String getDate()
    {
        return (new StringBuilder()).append(day).append("/").append(monthS).append("/").append(year).toString();
    }

    static final String MONTHS[] = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", 
        "Noviembre", "Diciembre"
    };
    int day;
    int month;
    int year;
    String monthS;

}
