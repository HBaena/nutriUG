// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DietaryHabits.java

package classes.usrclasses;


public class DietaryHabits
{

    public DietaryHabits()
    {
        questions = null;
        specifications = null;
        opcMeals = null;
    }

    public DietaryHabits(boolean questions[], String specifications[], int opcMeals[])
    {
        this.questions = questions;
        this.specifications = specifications;
        this.opcMeals = opcMeals;
    }

    public boolean[] getQuestions()
    {
        return questions;
    }

    public void setQuestions(boolean questions[])
    {
        this.questions = questions;
    }

    public String[] getSpecifications()
    {
        return specifications;
    }

    public void setSpecifications(String specifications[])
    {
        this.specifications = specifications;
    }

    public int[] getOpcMeals()
    {
        return opcMeals;
    }

    public void setOpcMeals(int opcMeals[])
    {
        this.opcMeals = opcMeals;
    }

    final String MEALS[] = {
        "breakfast", "lunch", "dinner", "another"
    };
    boolean questions[];
    String specifications[];
    int opcMeals[];
}
