/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormadvicecenter;

public class Tornado extends Storm
{
   public Tornado(float temp, int wind, String n )
   {
       temperature = temp;
       windspeed = wind;
       name = n;
       type = "Tornado";
   }
   
   @Override
   public int getClassification()
   {
       if (windspeed >= 40 || windspeed <=72)
           return 0;
       else if (windspeed >= 73 || windspeed <=112)
           return 1;
       else if (windspeed >= 113 || windspeed <=157)
           return 2;
       else if (windspeed >= 158 || windspeed <=205)
           return 3;
       else if (windspeed >= 206 || windspeed <=260)
           return 4;
       else if(windspeed >= 261)
           return 5;
       else
           return -1;
   }
   
   @Override
   public String getAdvice()
   {
       switch (getClassification())
       {
           case 0:
           case 1:
               return "Find safe room/shelter, shield yourself from debris";
           
           case 2:
           case 3:
           case 4:
           case 5:
               return "Find underground shelter, crouch near to the floor "
                       + "covering your head with your hands";
           
           default:
               return "There is no need to panic";
       }   
   }
}
