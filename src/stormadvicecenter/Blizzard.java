/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormadvicecenter;

public class Blizzard extends Storm
{
     public Blizzard(float temp, int wind, String n )
   {
       temperature = temp;
       windspeed = wind;
       name = n;
       type = "Blizzard";
   }
   
   @Override
   public int getClassification()
   {
       // Severe blizzard
       if (windspeed >=45 && temperature <= -12)
           return 2;
       // blizzard
       else if (windspeed >= 35 )
           return 1;
       // snow strom
       else
           return -1;
   }
   
   @Override
   public String getAdvice()
   {
       switch (getClassification())
       {
           case 1:
               return "Keep warm, Do not travel unless absolutely essential";
           
           case 2:
               return "Keep warm, avoid all travel";
           
           default:
               return "Take care and avoid travel if possible";
       }   
   }
}
