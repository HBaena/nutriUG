// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PersonalHabits.java

package classes.usrclasses;


public class PersonalHabits
{

    public PersonalHabits()
    {
        yes_no = new String[3];
    }

    public PersonalHabits(int countEat, int counCol, String yes_no[], String drinkFrequenty, String smokeFrequenty, String hungryHour, String placeFoods, 
            String whoFoods, int water)
    {
        this.countEat = countEat;
        this.counCol = counCol;
        this.yes_no = yes_no;
        this.drinkFrequenty = drinkFrequenty;
        this.smokeFrequenty = smokeFrequenty;
        this.hungryHour = hungryHour;
        this.placeFoods = placeFoods;
        this.whoFoods = whoFoods;
        this.water = water;
    }

    public PersonalHabits(String args[])
    {
        this();
        drinkFrequenty = args[5];
        smokeFrequenty = args[6];
        hungryHour = args[7];
        placeFoods = args[8];
        whoFoods = args[9];
        yes_no[0] = args[2];
        yes_no[1] = args[3];
        yes_no[2] = args[4];
        water = Integer.parseInt(args[10]);
        countEat = Integer.parseInt(args[0]);
        counCol = Integer.parseInt(args[1]);
    }

    public int getCountEat()
    {
        return countEat;
    }

    public void setCountEat(int countEat)
    {
        this.countEat = countEat;
    }

    public int getCounCol()
    {
        return counCol;
    }

    public void setCounCol(int counCol)
    {
        this.counCol = counCol;
    }

    public String[] getYes_no()
    {
        return yes_no;
    }

    public void setYes_no(String yes_no[])
    {
        this.yes_no = yes_no;
    }

    public String getDrinkFrequenty()
    {
        return drinkFrequenty;
    }

    public void setDrinkFrequenty(String drinkFrequenty)
    {
        this.drinkFrequenty = drinkFrequenty;
    }

    public String getSmokeFrequenty()
    {
        return smokeFrequenty;
    }

    public void setSmokeFrequenty(String smokeFrequenty)
    {
        this.smokeFrequenty = smokeFrequenty;
    }

    public String getHungryHour()
    {
        return hungryHour;
    }

    public void setHungryHour(String hungryHour)
    {
        this.hungryHour = hungryHour;
    }

    public String getPlaceFoods()
    {
        return placeFoods;
    }

    public void setPlaceFoods(String placeFoods)
    {
        this.placeFoods = placeFoods;
    }

    public String getWhoFoods()
    {
        return whoFoods;
    }

    public void setWhoFoods(String whoFoods)
    {
        this.whoFoods = whoFoods;
    }

    public int getWater()
    {
        return water;
    }

    public void setWater(int water)
    {
        this.water = water;
    }

    int countEat;
    int counCol;
    String yes_no[];
    String drinkFrequenty;
    String smokeFrequenty;
    String hungryHour;
    String placeFoods;
    String whoFoods;
    int water;
}
