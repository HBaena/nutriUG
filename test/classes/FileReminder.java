// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileReminder.java

package classes;

import java.io.*;
import java.util.Scanner;

public class FileReminder
{

    public FileReminder(String rute)
    {
        APPOI = "";
        PHOTO = "";
        reminder = "";
        this.rute = rute;
        read();
    }

    public String getReminder()
    {
        return reminder;
    }

    public void setReminder(String reminder)
    {
        this.reminder = reminder;
    }

    public void saveReminder(String reminder)
    {
        this.reminder = reminder;
        write();
    }

    private void read()
    {
        File file;
        Scanner scanner;
        file = new File(rute + "/REMINDER.txt");
        scanner = null;
        try {
            scanner = new Scanner(file);
            PHOTO = scanner.nextLine();
            APPOI = scanner.nextLine();
            reminder = scanner.nextLine();
        } catch (Exception e) {
        }
        

    }

    private void write()
    {
        FileWriter file = null;
        PrintWriter writer = null;
        try
        {
            file = new FileWriter(rute + "/REMINDER.txt");
            writer = new PrintWriter(file);
            reminder.replace('\n', ' ');
            writer.println(PHOTO);
            writer.println(APPOI);
            writer.println(reminder);
            writer.close();
        }
        catch(IOException ioexception) { }
    }

    String rute;
    String reminder;
    public String PHOTO;
    public String APPOI;
}
