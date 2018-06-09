// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HereditaryRecord.java

package classes.usrclasses;


public class HereditaryRecord
{

    public boolean[] getRecord()
    {
        return record;
    }

    public HereditaryRecord(boolean record[], boolean symptoms[])
    {
        this.record = record;
        this.symptoms = symptoms;
    }

    public HereditaryRecord(String args[])
    {
        this();
        int i;
        for(i = 0; i < record.length; i++)
            if(args[i].charAt(0) == 'y')
                record[i] = true;
            else
                record[i] = false;

        for(; i < record.length + symptoms.length; i++)
            if(args[i].charAt(0) == 'y')
                symptoms[i - symptoms.length] = true;
            else
                symptoms[i - symptoms.length] = false;

    }

    public void setRecord(boolean record[])
    {
        this.record = record;
    }

    public boolean[] getSymptoms()
    {
        return symptoms;
    }

    public void setSymptoms(boolean symptoms[])
    {
        this.symptoms = symptoms;
    }

    public HereditaryRecord()
    {
        record = new boolean[12];
        symptoms = new boolean[12];
    }

    boolean record[];
    boolean symptoms[];
}
