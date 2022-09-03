/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormadvicecenter;

public abstract class Storm 
{
    float temperature;
    int windspeed;
    String name;
    String type;
    abstract int getClassification();
    abstract  String getAdvice();
   
    @Override
    public String toString()
    {
        return String.format("Type : " + type + "\nName : " + name + 
                "\nWindSpeed : " + windspeed + "\nTemperature : " + temperature);
    }
}
