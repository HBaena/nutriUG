// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StudentData.java

package classes.usrclasses;


public class StudentData
{

    public StudentData()
    {
        educationalProgram = period = division = "";
    }

    public StudentData(String educationalProgram, String period, String division)
    {
        this.educationalProgram = educationalProgram;
        this.period = period;
        this.division = division;
    }

    public StudentData(String args[])
    {
        this();
        if(args.length != 3)
        {
            return;
        } else
        {
            educationalProgram = args[0];
            period = args[1];
            division = args[2];
            return;
        }
    }

    public String getEducationalProgram()
    {
        return educationalProgram;
    }

    public void setEducationalProgram(String educationalProgram)
    {
        this.educationalProgram = educationalProgram;
    }

    public String getPeriod()
    {
        return period;
    }

    public void setPeriod(String period)
    {
        this.period = period;
    }

    public String getDivision()
    {
        return division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }

    String educationalProgram;
    String period;
    String division;
}
