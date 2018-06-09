// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Phones.java

package classes.usrclasses;


public class Phones
{

    public Phones()
    {
        phone01 = phone02 = phone03 = "";
    }

    public Phones(String phone01, String phone02, String phone03)
    {
        this.phone01 = phone01;
        this.phone02 = phone02;
        this.phone03 = phone03;
    }

    public String getPhone01()
    {
        return phone01;
    }

    public void setPhone01(String phone01)
    {
        this.phone01 = phone01;
    }

    public String getPhone02()
    {
        return phone02;
    }

    public void setPhone02(String phone02)
    {
        this.phone02 = phone02;
    }

    public String getPhone03()
    {
        return phone03;
    }

    public void setPhone03(String phone03)
    {
        this.phone03 = phone03;
    }

    String phone01;
    String phone02;
    String phone03;
}
