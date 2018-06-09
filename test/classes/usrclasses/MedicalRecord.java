// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MedicalRecord.java

package classes.usrclasses;


public class MedicalRecord
{

    public MedicalRecord()
    {
        actualTreatment = actualAilment = surgeries = complemments = "";
    }

    public MedicalRecord(String actualAilment, String actualTreatment, String surgeries, String complemments)
    {
        this.actualTreatment = actualTreatment;
        this.actualAilment = actualAilment;
        this.surgeries = surgeries;
        this.complemments = complemments;
    }

    public MedicalRecord(String args[])
    {
        this();
        if(args.length != 4)
        {
            return;
        } else
        {
            actualTreatment = args[0].replace('\177', '\n');
            actualAilment = args[1].replace('\177', '\n');
            surgeries = args[2].replace('\177', '\n');
            complemments = args[3].replace('\177', '\n');
            return;
        }
    }

    public String getActualAilment()
    {
        return actualAilment;
    }

    public void setActualAilment(String actualAilment)
    {
        this.actualAilment = actualAilment;
    }

    public String getActualTreatment()
    {
        return actualTreatment;
    }

    public void setActualTreatment(String actualTreatment)
    {
        this.actualTreatment = actualTreatment;
    }

    public String getSurgeries()
    {
        return surgeries;
    }

    public void setSurgeries(String surgeries)
    {
        this.surgeries = surgeries;
    }

    public String getComplemments()
    {
        return complemments;
    }

    public void setComplemments(String complemments)
    {
        this.complemments = complemments;
    }

    String actualAilment;
    String actualTreatment;
    String surgeries;
    String complemments;
}
