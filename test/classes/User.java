// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   User.java

package classes;

import classes.usrclasses.AnthropometricData;
import classes.usrclasses.Diet;
import classes.usrclasses.DietaryHabits;
import classes.usrclasses.HereditaryRecord;
import classes.usrclasses.MedicalRecord;
import classes.usrclasses.PersonalData;
import classes.usrclasses.PersonalHabits;
import classes.usrclasses.PhysicalActivity;


public class User
{

    public User()
    {
        personalData = null;
        medicalRecord = null;
        anthropometricData = null;
        dietaryHabits = null;
        physicalActivity = null;
        hereditaryRecord = null;
        diet = null;
        personalHabits = null;
        annotations = "";
    }

    public User(PersonalData personalData, MedicalRecord medicalRecord, AnthropometricData anthropometricData, DietaryHabits dietaryHabits, PhysicalActivity physicalActivity, HereditaryRecord hereditaryRecord, PersonalHabits personalHabits, 
            Diet diet)
    {
        this.personalData = personalData;
        this.medicalRecord = medicalRecord;
        this.anthropometricData = anthropometricData;
        this.dietaryHabits = dietaryHabits;
        this.physicalActivity = physicalActivity;
        this.hereditaryRecord = hereditaryRecord;
        this.personalHabits = personalHabits;
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

    public PersonalHabits getPersonalHabits()
    {
        return personalHabits;
    }

    public void setPersonalHabits(PersonalHabits personalHabits)
    {
        this.personalHabits = personalHabits;
    }

    public Diet getDiet()
    {
        return diet;
    }

    public void setDiet(Diet diet)
    {
        this.diet = diet;
    }

    public PersonalData getPersonalData()
    {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData)
    {
        this.personalData = personalData;
    }

    public HereditaryRecord getHereditaryRecord()
    {
        return hereditaryRecord;
    }

    public void setHereditaryRecord(HereditaryRecord hereditaryRecord)
    {
        this.hereditaryRecord = hereditaryRecord;
    }

    public PhysicalActivity getPhysicalActivity()
    {
        return physicalActivity;
    }

    public void setPhysicalActivity(PhysicalActivity physicalActivity)
    {
        this.physicalActivity = physicalActivity;
    }

    public MedicalRecord getMedicalRecord()
    {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord)
    {
        this.medicalRecord = medicalRecord;
    }

    public AnthropometricData getAnthropometricData()
    {
        return anthropometricData;
    }

    public void setAnthropometricData(AnthropometricData anthropometricData)
    {
        this.anthropometricData = anthropometricData;
    }

    public DietaryHabits getDietaryHabits()
    {
        return dietaryHabits;
    }

    public void setDietaryHabits(DietaryHabits dietaryHabits)
    {
        this.dietaryHabits = dietaryHabits;
    }

    PersonalData personalData;
    MedicalRecord medicalRecord;
    AnthropometricData anthropometricData;
    DietaryHabits dietaryHabits;
    PhysicalActivity physicalActivity;
    HereditaryRecord hereditaryRecord;
    Diet diet;
    PersonalHabits personalHabits;
    String annotations;
}
