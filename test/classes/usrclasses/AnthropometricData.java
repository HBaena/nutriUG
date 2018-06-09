// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnthropometricData.java

package classes.usrclasses;


public class AnthropometricData
{

    public AnthropometricData()
    {
        weight = height = waistLine = BMI = 0.0F;
        risk = "";
        DX = "";
    }

    public AnthropometricData(float weight, float height, float waistLine, float hipLine, float BMI, String risk, String DX)
    {
        this.weight = weight;
        this.height = height;
        this.waistLine = waistLine;
        this.hipLine = hipLine;
        this.BMI = BMI;
        this.risk = risk;
        this.DX = DX;
    }

    public AnthropometricData(String args[])
    {
        this();
        if(args.length != 7)
        {
            return;
        } else
        {
            weight = Float.parseFloat(args[0]);
            height = Float.parseFloat(args[1]);
            waistLine = Float.parseFloat(args[2]);
            hipLine = Float.parseFloat(args[3]);
            BMI = Float.parseFloat(args[4]);
            risk = args[5];
            DX = args[6];
            return;
        }
    }

    public float getHipLine()
    {
        return hipLine;
    }

    public void setHipLine(float hipLine)
    {
        this.hipLine = hipLine;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public float getHeight()
    {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public float getWaistLine()
    {
        return waistLine;
    }

    public void setWaistLine(float waistLine)
    {
        this.waistLine = waistLine;
    }

    public float getBMI()
    {
        return BMI;
    }

    public void setBMI(float BMI)
    {
        this.BMI = BMI;
    }

    public String getRisk()
    {
        return risk;
    }

    public void setRisk(String risk)
    {
        this.risk = risk;
    }

    public String getDX()
    {
        return DX;
    }

    public void setDX(String DX)
    {
        this.DX = DX;
    }

    float weight;
    float height;
    float waistLine;
    float hipLine;
    float BMI;
    String risk;
    String DX;
}
