/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormadvicecenter;
public class Hurricane extends Storm
{
    public Hurricane(float temp, int wind, String n )
   {
       temperature = temp;
       windspeed = wind;
       name = n;
       type = "Hurricane";
   }
   
   @Override
   public int getClassification()
   {
       if (windspeed >= 74 || windspeed <=95)
           return 1;
       else if (windspeed >= 96 || windspeed <=110)
           return 2;
       else if (windspeed >= 111 || windspeed <=129)
           return 3;
       else if (windspeed >= 130 || windspeed <=156)
           return 4;
       else if (windspeed > 156)
           return 5;
       else
           return -1;
   }
   
   @Override
   public String getAdvice()
   {
       switch (getClassification())
       {
           case -1:
           case 1:
           case 2:
               return "Close storm shutters and stay away from windows";
           
           case 3:
               return "Coastal regions are encouraged to evacuate";
           
           default:
               return "Evacuate";
       }   
   }
   
}
