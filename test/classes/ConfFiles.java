// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConfFiles.java

package classes;

import java.io.*;
import java.util.Scanner;

public class ConfFiles
{

    public ConfFiles(String rootpath, String pdfFiles, String profileMail, String passwordMail, String nameOwner)
    {
        this.rootpath = rootpath;
        this.pdfFiles = pdfFiles;
        this.profileMail = profileMail;
        this.passwordMail = passwordMail;
        this.nameOwner = nameOwner;
    }

    public ConfFiles(String rute)
    {
        this.rute = rute;
        rootpath = "";
        pdfFiles = "";
        profileMail = "";
        passwordMail = "";
        nameOwner = "";
    }

    public String getRootpath()
    {
        return rootpath;
    }

    public String getPdfFiles()
    {
        return pdfFiles;
    }

    public String getProfileMail()
    {
        return profileMail;
    }

    public String getPasswordMail()
    {
        return passwordMail;
    }

    public String getNameOwner()
    {
        return nameOwner;
    }

    public void create()
    {
    }

    public void write()
    {
        try
        {
            FileWriter file = new FileWriter(rute);
            PrintWriter writer = new PrintWriter(file);
            writer.println(rootpath);
            writer.println(pdfFiles);
            writer.println(profileMail);
            writer.println(passwordMail);
            writer.println(nameOwner);
            writer.close();
        }
        catch(Exception exception) { }
    }

    public void read()
    {
        try
        {
            File file = new File(rute);
            Scanner scanner = new Scanner(file);
            rootpath = scanner.nextLine();
            pdfFiles = scanner.nextLine();
            profileMail = scanner.nextLine();
            passwordMail = scanner.nextLine();
            nameOwner = scanner.nextLine();
            scanner.close();
        }
        catch(Exception exception) { }
    }

    String rootpath;
    String pdfFiles;
    String profileMail;
    String passwordMail;
    String nameOwner;
    String rute;
}
