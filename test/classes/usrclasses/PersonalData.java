// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PersonalData.java

package classes.usrclasses;


public class PersonalData
{

    public PersonalData()
    {
        name = NUA = eMail = phone = "";
        genere = '\0';
    }

    public PersonalData(String name, String NUA, String eMail, char genere, String phone, String adress)
    {
        this.name = name;
        this.NUA = NUA;
        this.eMail = eMail;
        this.genere = genere;
        this.phone = phone;
        this.adress = adress;
    }

    public PersonalData(String args[])
    {
        this();
        if(args.length != 6)
        {
            return;
        } else
        {
            name = args[0];
            NUA = args[1];
            eMail = args[2];
            genere = args[3].charAt(0);
            phone = args[4];
            adress = args[5];
            return;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNUA()
    {
        return NUA;
    }

    public void setNUA(String NUA)
    {
        this.NUA = NUA;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public String geteMail()
    {
        return eMail;
    }

    public void seteMail(String eMail)
    {
        this.eMail = eMail;
    }

    public char getGenere()
    {
        return genere;
    }

    public void setGenere(char genere)
    {
        this.genere = genere;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhones(String phone)
    {
        this.phone = phone;
    }

    String name;
    String NUA;
    String eMail;
    char genere;
    String phone;
    String adress;
}
