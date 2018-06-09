// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Diet.java

package classes.usrclasses;


public class Diet
{

    public Diet()
    {
        types = new String[22];
        perDay = new String[22];
        perWeek = new String[22];
        perMonth = new String[22];
    }

    public Diet(String types[], String perDay[], String perWeek[], String perMonth[])
    {
        this.types = types;
        this.perDay = perDay;
        this.perWeek = perWeek;
        this.perMonth = perMonth;
    }

    public Diet(String args[])
    {
        int i;
        for(i = 0; i < 22; i++)
            types[i] = args[i];

        for(; i < 44; i++)
            perDay[i - 22] = args[i];

        for(; i < 66; i++)
            perWeek[i - 44] = args[i];

        for(; i < 88; i++)
            perMonth[i - 66] = args[i];

    }

    public String[] getTypes()
    {
        return types;
    }

    public void setTypes(String types[])
    {
        this.types = types;
    }

    public String[] getPerDay()
    {
        return perDay;
    }

    public void setPerDay(String perDay[])
    {
        this.perDay = perDay;
    }

    public String[] getPerWeek()
    {
        return perWeek;
    }

    public void setPerWeek(String perWeek[])
    {
        this.perWeek = perWeek;
    }

    public String[] getPerMonth()
    {
        return perMonth;
    }

    public void setPerMonth(String perMonth[])
    {
        this.perMonth = perMonth;
    }

    private String types[];
    private String perDay[];
    private String perWeek[];
    private String perMonth[];
}
