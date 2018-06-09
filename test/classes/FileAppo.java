// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileAppo.java

package classes;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileAppo
{

    public FileAppo(String rute, String name)
    {
        this.name = name;
        this.rute = (new StringBuilder()).append(rute).append(name).append(".txt").toString();
    }

    public void write()
    {
        try
        {
            FileWriter file = new FileWriter(rute);
            PrintWriter writer = new PrintWriter(file);
            writer.print("FECHA: ");
            writer.print((new StringBuilder()).append(date).append('\n').toString());
            writer.print("PESO: ");
            writer.print((new StringBuilder()).append(weight).append('\n').toString());
            writer.print("CINCTURA: ");
            writer.print((new StringBuilder()).append(waist).append('\n').toString());
            writer.print("CADERA: ");
            writer.print((new StringBuilder()).append(hip).append('\n').toString());
            writer.print("IMC: ");
            writer.print((new StringBuilder()).append(imc).append('\n').toString());
            writer.println("SOBRE DIETA");
            diet = (new StringBuilder()).append("  - ").append(diet).toString().replace("\n", "\n  - ");
            writer.print((new StringBuilder()).append(diet).append('\n').toString());
            writer.println("OBSERVACIONES");
            annotations = (new StringBuilder()).append("  - ").append(annotations).toString().replace("\n", "\n  - ");
            writer.print((new StringBuilder()).append(annotations).append('\n').toString());
            writer.close();
        }
        catch(Exception exception) { }
    }

    public void read()
    {
        Scanner scanner = null;
        File file = new File(rute);
        try {
            scanner = new Scanner(file);
            allDoc = "";
            while(scanner.hasNextLine())  allDoc += scanner.nextLine() + "\n";
            scanner.close();
        } catch (Exception e) {
        }
        
    }

    public String getAppoiment()
    {
        return allDoc;
    }

    public String getName()
    {
        return name;
    }

    public String getRute()
    {
        return rute;
    }

    public void setRute(String rute)
    {
        this.rute = rute;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getHeigth()
    {
        return heigth;
    }

    public void setHeigth(String heigth)
    {
        this.heigth = heigth;
    }

    public String getWaist()
    {
        return waist;
    }

    public void setWaist(String waist)
    {
        this.waist = waist;
    }

    public String getHip()
    {
        return hip;
    }

    public void setHip(String hip)
    {
        this.hip = hip;
    }

    public String getImc()
    {
        return imc;
    }

    public void setImc(String imc)
    {
        this.imc = imc;
    }

    public String getDiet()
    {
        return diet;
    }

    public void setDiet(String diet)
    {
        this.diet = diet;
    }

    public String getAnnotations()
    {
        return annotations;
    }

    public void setAnnotations(String annotations)
    {
        this.annotations = annotations;
    }

    String rute;
    String date;
    String weight;
    String heigth;
    String waist;
    String hip;
    String imc;
    String diet;
    String annotations;
    String allDoc;
    String name;
}
