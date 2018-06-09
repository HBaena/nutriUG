// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileUsr.java

package classes;

import classes.usrclasses.AnthropometricData;
import classes.usrclasses.Diet;
import classes.usrclasses.HereditaryRecord;
import classes.usrclasses.MedicalRecord;
import classes.usrclasses.PersonalData;
import classes.usrclasses.PersonalHabits;
import classes.usrclasses.PhysicalActivity;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

// Referenced classes of package classes:
//            User, Message

public class FileUsr
{

    public FileUsr(ArrayList userArrayList, String fileName)
    {
        this.userArrayList = userArrayList;
        this.fileName = fileName;
    }

    public FileUsr(String fileName)
    {
        userArrayList = new ArrayList();
        this.fileName = fileName;
    }

    private boolean read()
    {
        File file;
        Scanner scanner;
        try
        {
            file = new File(fileName+".USERDATA/DATA.txt");
            scanner = null;
            String tmp;
            boolean flag;
            scanner = new Scanner(file);
            tmp = scanner.nextLine();
            if(tmp.isEmpty())
                return false;
            
            flag = true;
        
        int N = Integer.parseInt(tmp);
        for(int i = 0; i < N; i++)
        {
            User userTmp = new User();
            String tmpArray[] = makeArray(scanner.nextLine());
            PersonalData tmpPersonalData = new PersonalData(tmpArray);
            userTmp.setPersonalData(tmpPersonalData);
            tmpArray = makeArray(scanner.nextLine());
            MedicalRecord tmpMedicalRecord = new MedicalRecord(tmpArray);
            userTmp.setMedicalRecord(tmpMedicalRecord);
            tmpArray = makeArray(scanner.nextLine());
            PhysicalActivity tmpPhysicalActivity = new PhysicalActivity(tmpArray);
            userTmp.setPhysicalActivity(tmpPhysicalActivity);
            tmpArray = makeArray(scanner.nextLine());
            AnthropometricData tmpAnData = new AnthropometricData(tmpArray);
            userTmp.setAnthropometricData(tmpAnData);
            tmpArray = makeArray(scanner.nextLine());
            HereditaryRecord tmpHereditary = new HereditaryRecord(tmpArray);
            userTmp.setHereditaryRecord(tmpHereditary);
            Diet tmpDiet = new Diet(makeArray(scanner.nextLine()), makeArray(scanner.nextLine()), makeArray(scanner.nextLine()), makeArray(scanner.nextLine()));
            userTmp.setDiet(tmpDiet);
            tmpArray = makeArray(scanner.nextLine());
            PersonalHabits tmpPersonalHabits = new PersonalHabits(tmpArray);
            userTmp.setPersonalHabits(tmpPersonalHabits);
            userArrayList.add(userTmp);
        }
    }
        catch(Exception e2)
        {
            e2.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean write(String rute)
    {
        FileWriter file = null;
        PrintWriter writer = null;
        Iterator userIt = userArrayList.iterator();
        try
        {
            file = new FileWriter(rute + "/DATA.txt");
            writer = new PrintWriter(file);
            userIt = userArrayList.iterator();
            writer.println(userArrayList.size());
            do
            {
                if(!userIt.hasNext())
                    break;
                User userTmp = (User)userIt.next();
                printPersonalData(writer, userTmp.getPersonalData());
                printMedicalRecord(writer, userTmp.getMedicalRecord());
                printPhysicalActivity(writer, userTmp.getPhysicalActivity());
                printAnthropometricData(writer, userTmp.getAnthropometricData());
                printHereditaryRecord(writer, userTmp.getHereditaryRecord());
                printDiet(writer, userTmp.getDiet());
                printPersonalHabits(writer, userTmp.getPersonalHabits());
                File tmpFile = new File((new StringBuilder()).append(rute).append(userTmp.getPersonalData().getName()).toString());
                if(tmpFile.mkdir())
                    tmpFile.mkdirs();
            } while(true);
            file.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            (new Message(new Object[] {
                "Ok"
            }, "Error", "Error al escribir")).showMessage();
            return false;
        }
        return true;
    }

    private void createDir()
    {
        String rute = (new StringBuilder()).append(fileName).append(".USERDATA/").toString();
        File file = new File(rute);
        if(file.mkdir())
            file.mkdirs();
        write(rute);
    }

    public ArrayList getList()
    {
        if(userArrayList.size() == 0)
            read();
        return userArrayList;
    }

    public void save()
    {
        createDir();
    }

    void printPersonalData(PrintWriter writer, PersonalData personalData)
    {
        writer.print((new StringBuilder()).append(personalData.getName()).append(":").toString());
        writer.print((new StringBuilder()).append(personalData.getNUA()).append(":").toString());
        writer.print((new StringBuilder()).append(personalData.geteMail()).append(":").toString());
        writer.print((new StringBuilder()).append(personalData.getGenere()).append(":").toString());
        writer.print((new StringBuilder()).append(personalData.getPhone()).append(":").toString());
        writer.println(personalData.getAdress());
    }

    void printMedicalRecord(PrintWriter writer, MedicalRecord medicalRecord)
    {
        writer.print((new StringBuilder()).append(medicalRecord.getActualAilment().replace('\n', '\177')).append(":").toString());
        writer.print((new StringBuilder()).append(medicalRecord.getActualTreatment().replace('\n', '\177')).append(":").toString());
        writer.print((new StringBuilder()).append(medicalRecord.getSurgeries().replace('\n', '\177')).append(":").toString());
        writer.println(medicalRecord.getComplemments().replace('\n', '\177'));
    }

    void printPhysicalActivity(PrintWriter writer, PhysicalActivity physicalActivity)
    {
        writer.print((new StringBuilder()).append(physicalActivity.getYes_no()).append(":").toString());
        writer.print((new StringBuilder()).append(physicalActivity.getWhich()).append(":").toString());
        writer.print((new StringBuilder()).append(physicalActivity.getDuration()).append(":").toString());
        writer.println(physicalActivity.getFrequency());
    }

    void printAnthropometricData(PrintWriter writer, AnthropometricData anthropometricData)
    {
        writer.print((new StringBuilder()).append(anthropometricData.getWeight()).append(":").toString());
        writer.print((new StringBuilder()).append(anthropometricData.getHeight()).append(":").toString());
        writer.print((new StringBuilder()).append(anthropometricData.getWaistLine()).append(":").toString());
        writer.print((new StringBuilder()).append(anthropometricData.getHipLine()).append(":").toString());
        writer.print((new StringBuilder()).append(anthropometricData.getBMI()).append(":").toString());
        writer.print((new StringBuilder()).append(anthropometricData.getRisk()).append(":").toString());
        writer.println(anthropometricData.getDX());
    }

    void printHereditaryRecord(PrintWriter writer, HereditaryRecord hereditaryRecord)
    {
        boolean tmp[] = hereditaryRecord.getRecord();
        for(int i = 0; i < tmp.length; i++)
            writer.print((new StringBuilder()).append(tmp[i] ? 'y' : 'n').append(":").toString());

        tmp = hereditaryRecord.getSymptoms();
        for(int i = 0; i < tmp.length; i++)
            if(i != tmp.length - 1)
                writer.print((new StringBuilder()).append(tmp[i] ? 'y' : 'n').append(":").toString());
            else
                writer.println(tmp[i] ? 'y' : 'n');

    }

    void printPersonalHabits(PrintWriter writer, PersonalHabits personalHabits)
    {
        writer.print((new StringBuilder()).append(personalHabits.getCountEat()).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getCounCol()).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getYes_no()[0]).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getYes_no()[1]).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getYes_no()[2]).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getDrinkFrequenty()).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getSmokeFrequenty()).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getHungryHour()).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getPlaceFoods()).append(":").toString());
        writer.print((new StringBuilder()).append(personalHabits.getWhoFoods()).append(":").toString());
        writer.println(personalHabits.getWater());
    }

    void printDiet(PrintWriter writer, Diet diet)
    {
        int LENGTH = diet.getTypes().length;
        for(int i = 0; i < LENGTH; i++)
            writer.print((new StringBuilder()).append(diet.getTypes()[i].isEmpty() ? "'" : diet.getTypes()[i]).append(":").toString());

        writer.println();
        for(int i = 0; i < LENGTH; i++)
            writer.print((new StringBuilder()).append(diet.getPerDay()[i].isEmpty() ? "'" : diet.getPerDay()[i]).append(":").toString());

        writer.println();
        for(int i = 0; i < LENGTH; i++)
            writer.print((new StringBuilder()).append(diet.getPerWeek()[i].isEmpty() ? "'" : diet.getPerWeek()[i]).append(":").toString());

        writer.println();
        for(int i = 0; i < LENGTH; i++)
            writer.print((new StringBuilder()).append(diet.getPerMonth()[i].isEmpty() ? "'" : diet.getPerMonth()[i]).append(":").toString());

        writer.println();
    }

    String[] makeArray(String line)
    {
        return line.split(":");
    }

    static final char CHARSTOP = 47;
    ArrayList userArrayList;
    String fileName;
}
