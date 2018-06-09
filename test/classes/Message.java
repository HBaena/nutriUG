// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Message.java

package classes;

import javax.swing.JOptionPane;

public class Message
{

    public Message()
    {
        title = "Error";
        massage = "Algo anda mal";
    }

    public Message(String massage)
    {
        this();
        massage = massage;
    }

    public Message(Object options[], String title, String massage)
    {
        this.title = title;
        this.massage = massage;
        this.options = options;
    }

    public int showMessage()
    {
        return JOptionPane.showOptionDialog(null, massage, title, -1, 3, null, options, ((Object) (options)));
    }

    public int showMessage(String massege)
    {
        return JOptionPane.showOptionDialog(null, massage, title, -1, 3, null, options, ((Object) (options)));
    }

    public int showMessage(Object options[], String title, String massage)
    {
        return JOptionPane.showOptionDialog(null, massage, title, -1, 3, null, options, ((Object) (options)));
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setMassage(String massage)
    {
        this.massage = massage;
    }

    public void setOptions(Object options[])
    {
        this.options = options;
    }

    String title;
    String massage;
    Object options[] = {
        "Ok"
    };
}
