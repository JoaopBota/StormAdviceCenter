
package stormadvicecenter;

import java.util.Scanner;
import java.io.*;

public class StormAdviceCenter 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Storm[] storms = new Storm[20];
        int windspeed, input, index =0;
        float temperature;
        String name, type;
        String data[];
        StormAdviceCenter sac = new StormAdviceCenter();
        try
        {
            
            File file = new File("StormInfo.txt");
            Scanner scanFile = new Scanner(file);
            while (scanFile.hasNextLine())
            {
                data = scanFile.nextLine().split(",");  // store each value in String[]
                if(data.length ==4)
                {
                    name = data[0];
                    type = data[1];
                    windspeed = Integer.parseInt(data[2]);
                    temperature = Float.parseFloat(data[3]);

                    if (type.equals("Hurricane"))
                        storms[index] = new Hurricane(temperature, windspeed, name);
                    else if(type.equals("Blizzard"))
                        storms[index] = new Blizzard(temperature, windspeed, name);
                    else
                         storms[index] = new Tornado(temperature, windspeed, name);
                    index++;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        do
        {
            input = sac.Menu();
            switch(input)
            {
                // add storm
                case 1:
                    if (index < 20 )
                    {
                        boolean ok = false;
                        while(!ok)
                        {
                            index++;
                            try
                            {
                                System.out.print("Please enter strom "
                                        + "type [Hurricane/Blizzard/Tornado]:\n>> ");
                                type = scanner.nextLine();
                                System.out.print("Please enter " + type
                                        + "'s name:\n>> ");
                                name = scanner.nextLine();
                                System.out.print("Please enter " + name 
                                        + "'s windspeed:\n>> ");
                                windspeed = Integer.parseInt(scanner.nextLine());
                                System.out.print("Pleaser enter " + name
                                        + "'s temeprature:\n>> ");
                                temperature = Float.parseFloat(scanner.nextLine());
                                ok = true;
                                if (type.equals("Hurricane"))
                                {
                                    storms[index] = new Hurricane(temperature, 
                                            windspeed, name);
                                    
                                    System.out.println(name + " has been added");
                                }
                                else if(type.equals("Blizzard"))
                                {
                                    storms[index] = new Blizzard(temperature, 
                                            windspeed, name);
                                    System.out.println(name + " has been added");
                                }
                                else if (type.equals("Tornado"))
                                {
                                     storms[index] = new Tornado(temperature, 
                                             windspeed, name);
                                    System.out.println(name + " has been added");
                                }
                                else
                                {
                                    System.out.println("Invalid type.. try again...");
                                    ok = false;
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println(e.toString() + "\nPlease Try again...");
                            }
                        }
                    }
                    else
                        System.out.println("Already 20 storms are added...\n"
                                + " Please remove a storm (using option 4) then"
                                + " add again");
                    
                    break;

                // get advice    
                case 2:
                    System.out.print("Enter Storm name:\n>> ");
                    String stormName = scanner.nextLine();
                    int found =sac.searchStorm(storms, stormName);
                    if(-1 != found )
                    {
                        System.out.println("Advice: " + storms[found].getAdvice());
                    }
                    else
                        System.out.println("No storm found with name "+ stormName
                        + "\nMake sure you have typed name correctly"
                                + ", select option 5 to see storms names.");
                    break;

                // edit storm
                case 3:
                    System.out.print("Enter Storm name:\n>> ");
                    stormName = scanner.nextLine();
                    found =sac.searchStorm(storms, stormName);
                    if(-1 != found )
                    {
                        boolean ok = false;
                        while(!ok)
                        {
                        try
                            {
                                System.out.print("Please enter strom "
                                        + " new type [Hurricane/Blizzard/Tornado]:\n>> ");
                                type = scanner.nextLine();
                                System.out.print("Please enter " + type
                                        + "'s new name:\n>> ");
                                name = scanner.nextLine();
                                System.out.print("Please enter " + name 
                                        + "'s new windspeed:\n>> ");
                                windspeed = Integer.parseInt(scanner.nextLine());
                                System.out.print("Pleaser enter " + name
                                        + "'s new temeprature:\n>> ");
                                temperature = Float.parseFloat(scanner.nextLine());
                                ok = true;
                                if (type.equals("Hurricane"))
                                {
                                    System.out.println(storms[found].name + " has been edited");
                                    storms[found] = new Hurricane(temperature, 
                                            windspeed, name);
                                }
                                else if(type.equals("Blizzard"))
                                {
                                    System.out.println(storms[found].name + " has been edited");
                                    storms[found] = new Blizzard(temperature, 
                                            windspeed, name);
                                }
                                else if (type.equals("Tornado"))
                                {
                                    System.out.println(storms[found].name + " has been edited");
                                     storms[found] = new Tornado(temperature, 
                                             windspeed, name);
                                }
                                else
                                {
                                    System.out.println("Invalid type.. try again...");
                                    ok = false;
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println(e.toString() + "\nPlease Try again...");
                            }
                        }
                    }
            
                    else
                        System.out.println("No storm found with name "+ stormName
                        + "\nMake sure you have typed name correctly"
                                + ", select option 5 to see storms names.");
                    break;

                // delete storm
                case 4:
                    System.out.print("Enter Storm name:\n>> ");
                    stormName = scanner.nextLine();
                    found =sac.searchStorm(storms, stormName);
                    if(-1 != found )
                    {
                        storms[found] = null;
                        System.out.println(stormName +" have been DELETED !");
                    }
                    else
                        System.out.println("No storm found with name "+ stormName
                        + "\nMake sure you have typed name correctly"
                                + ", select option 5 to see storms names.");
                    break;
                
                // print storms
                case 5:
                    
                    for (Object storm : storms)
                        if (storm != null)
                        {
                            System.out.println(storm);
                            System.out.println();
                        }
                    break;
            
            }
        }while(input != 0);
        
        // updated file
        try (PrintWriter writer = new PrintWriter("StormInfo.txt", "UTF-8"))
        {
            for(Storm storm : storms)
            {
                
                if(storm != null)
                {
                    writer.println(storm.name+","+storm.type+","
                            +storm.windspeed+","+storm.temperature);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public int searchStorm(Storm[] arr, String key)
    {
        for(int i = 0; i<arr.length;i++)
        {
            if(arr[i] != null && arr[i].name.equals(key))
                return i;
        }
        return -1;
    }
    
    // take user input 
    public int Menu()
    {
        Scanner scan = new Scanner(System.in);
        String check = "-1";
        int choice = -1; // for handling Non Integer inputs
        boolean input = false;
        
        // while correct input has not been provided
        do
        {
            System.out.println("\n\t\t===== Storm Advice Center =====");
            System.out.println("\n(1) - Add Storm");
            System.out.println("(2) - Get Advice");
            System.out.println("(3) - Edit Storm");
            System.out.println("(4) - Delete Storm");
            System.out.println("(5) - Show Storms");
            System.out.printf("(0) - Quit\n>> ");
            check = scan.nextLine();
            // For Non Integer Input
            try
            {			
                choice = Integer.parseInt(check);
                if(choice >=0 && choice <=5)
                    input = true;
                else
                {
                    input = false;
                    System.out.println("Invalid Input ! Please Try Agian.");
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid Input ! Please Try Agian.");
                input = false;	
            }
        }while ( !(input) );
        return choice;
    }
    
}
