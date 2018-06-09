// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PhysicalActivity.java

package classes.usrclasses;


public class PhysicalActivity
{

    public PhysicalActivity(String yes_no, String which, int duration, String frequency)
    {
        this.yes_no = yes_no;
        this.which = which;
        this.duration = duration;
        this.frequency = frequency;
    }

    public PhysicalActivity(String args[])
    {
        if(args.length != 4)
        {
            return;
        } else
        {
            yes_no = args[0];
            which = args[1];
            duration = Integer.parseInt(args[2]);
            frequency = args[3];
            return;
        }
    }

    public String getYes_no()
    {
        return yes_no;
    }

    public void setYes_no(String yes_no)
    {
        this.yes_no = yes_no;
    }

    public String getWhich()
    {
        return which;
    }

    public void setWhich(String which)
    {
        this.which = which;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public String getFrequency()
    {
        return frequency;
    }

    public void setFrequency(String frequency)
    {
        this.frequency = frequency;
    }

    String yes_no;
    String which;
    int duration;
    String frequency;
}
