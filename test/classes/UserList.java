// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserList.java

package classes;

import classes.usrclasses.PersonalData;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package classes:
//            FileUsr, User

public class UserList
{
    
    
    public UserList(String fileName)
    {
        this.fileName = fileName;
        FileUsr users = new FileUsr(fileName);
        usersList = users.getList();
        namesArray = new String[usersList.size()];
        Iterator it = usersList.iterator();
        int i = 0;
        while(it.hasNext()) 
        {
            User tmp = (User)it.next();
            namesArray[i++] = tmp.getPersonalData().getName();
        }
    }

    public void saveList()
    {
        FileUsr users = new FileUsr(usersList, fileName);
        users.save();
    }

    public ArrayList getUsersList()
    {
        return usersList;
    }

    public void userAdd(User user)
    {
        usersList.add(user);
        namesArray = new String[usersList.size()];
        Iterator it = usersList.iterator();
        int i = 0;
        while(it.hasNext()) 
        {
            User tmp = (User)it.next();
            namesArray[i++] = tmp.getPersonalData().getName();
        }
    }

    public void setUsersList(ArrayList usersList)
    {
        this.usersList = usersList;
    }

    public String[] getNamesArray()
    {
        return namesArray;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void delete(int index)
    {
        usersList.remove(index);
        namesArray = new String[usersList.size()];
        Iterator it = usersList.iterator();
        int i = 0;
        while(it.hasNext()) 
        {
            User tmp = (User)it.next();
            namesArray[i++] = tmp.getPersonalData().getName();
        }
    }

    ArrayList usersList;
    String namesArray[];
    FileUsr users;
    String fileName;
}
