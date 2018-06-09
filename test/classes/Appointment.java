// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Appointment.java

package classes;

import java.util.Date;

// Referenced classes of package classes:
//            Date

public class Appointment
{

    public Appointment()
    {
        height = weight = 0;
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        date = new classes.Date(sqlDate);
    }

    public classes.Date getDate()
    {
        return date;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWeight()
    {
        return weight;
    }

    private int height;
    private int weight;
    private classes.Date date;
    private String anottations;
}
