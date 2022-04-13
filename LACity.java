import java.util.*;
import java.lang.String;
import java.io.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* Class containing left and right child of current
node and key value*/
class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}


class Info
{
Info()
{	
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                            WELCOME TO LA CITY DATABASE                                |\n");
System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n");
}

//Declaring variales to be used
Scanner scan=new Scanner(System.in);
String name;
double latitude;
int population;
double longitude;

//To take a pause
private void pressAnyKeyToContinue()
 { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {
        System.out.println("Press 'Enter' key to continue!");
        }  
 }
 //Taking multiple words
String readString()
{
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
}

//To get Date
 public void getCurrentTimeUsingDate() 
  {
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
  
  }

void menu()
{
//giving option to the user for their choice
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\t\t\t  LA CITY DATABASE \n\n");	
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
System.out.print("\t\t\t\t\t________________________________________________________________________________________ \n");
System.out.print("\t\t\t\t\t|                                         	                                            |\n");
System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n");
System.out.println("\t\t\t\t| 1 >> Display the information of all the cities                                        |");
System.out.println("\t\t\t\t| 2 >> Search a city                                                                    |");
System.out.println("\t\t\t\t| 3 >> Insert a city                                                                    |");
System.out.println("\t\t\t\t| 4 >> Delete a city                                                                    | ");        
System.out.println("\t\t\t\t| 5 >> Update the population of a city                                                  |");    
System.out.println("\t\t\t\t| 6 >> Find the distance between two cities                                             |");
System.out.println("\t\t\t\t| 7 >> Find nearby cities                                                               |");    
System.out.println("\t\t\t\t| 8 >> Exit the City Database                                                           |");
System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n\n");
System.out.print("\t\t\t\t\t\tEnter your choice: ");
Scanner sc= new Scanner(System.in);    //System.in is a standard input stream   
int b= sc.nextInt();  
switch (b)
{
case 1 : menu1();
break;
case 2: menu2();
break;
case 3: insert();
break;
case 4: delete();
break;
case 5: update();
break;
case 6: distance();
break;
case 7: nearby();
break;
case 8: exit();
break;
default: System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
  System.out.print("\t\t\t\t\t\tTry again...........\n\n");
  menu();
}
}
private void nearby() {
    File file = new File("LATowns.txt");
    String fname;
    // enter filename along with its extension
    System.out.print("Enter the Name of City to Search Nearby: ");
    Scanner sc1 = new Scanner(System.in);
    fname = sc1.next(); 
    ArrayList<String> str = new ArrayList<>(); 
    try (BufferedReader br= new BufferedReader(new FileReader(file))) {
        // Declaring a string variable
        String st;
        // Condition holds true till
        String heading = br.readLine();
        while ((st = br.readLine()) != null){
            if(st.indexOf(fname)!=-1) {
                      //System.out.println(s);
                String nextLine = br.readLine();
                String nextLine1 = br.readLine();
                str.add(nextLine);
                str.add(nextLine1);
             }
        }
     // Print the string
     System.out.println("Cities Found Near:");
     System.out.println(heading); 
     if(str.isEmpty()){
        System.out.println("No such City:");
     }
     for (String s : str) 
     { 
         System.out.println(s); 
     }
     // System.out.println(str);
     br.close();
 } catch (IOException e) {
     System.out.print("An Error Occured.");
 }
       menu();
}
void menu1()
{
//giving option to the user for their choice
System.out.print("\t\t\t\t\t ________________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\t\t\t  LA CITY DATABASE \n\n");    
System.out.print("\t\t\t\t\t ________________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
System.out.print("\t\t\t\t\t_________________________________________________________________________________________ \n");
System.out.print("\t\t\t\t\t|                                                                                        |\n");
System.out.print("\t\t\t\t\t|________________________________________________________________________________________|\n");
System.out.println("\t\t\t\t| 1 >> Inorder, preorder, and postorder of the cities in terms of their names,           |");
System.out.println("\t\t\t\t| 2 >> Inorder, preorder, and postorder of the cities in the terms of their populations  |");   
System.out.println("\t\t\t\t| 3 >> Exit to top menu                                                                  |");
System.out.print("\t\t\t\t\t|________________________________________________________________________________________|\n\n");
System.out.print("\t\t\t\t\t\tEnter your choice: ");
Scanner sc= new Scanner(System.in);    //System.in is a standard input stream   
int a= sc.nextInt();  
//if inputed choice is other than given choice
switch(a)
{
case 1 : showCities();
break;
case 2: orderedPopulation();
break;
case 3: menu();
break;
default: System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
  System.out.print("\t\t\t\t\t\tTry again...........\n\n");
  menu();
}

}

private void orderedPopulation() {
File file = new File("LATowns.txt");
ArrayList<String> str = new ArrayList<>();
try (BufferedReader br= new BufferedReader(new FileReader(file))) {
       // Declaring a string variable
       String st;
       // Condition holds true till
       String heading = br.readLine();
       while ((st = br.readLine()) != null)
       str.add(st);
    // Print the string
    System.out.println("Contents ordered by population:");
    System.out.println(heading); 
    for (String s : str) 
    { 
        System.out.println(s); 
    }
    // System.out.println(str);
    br.close();
} catch (IOException e) {
    System.out.print("An Error Occured.");
}
menu1();
}
private void showCities() {
File file = new File("LATowns.txt");
ArrayList<String> str = new ArrayList<>();
try (BufferedReader br= new BufferedReader(new FileReader(file))) {
       // Declaring a string variable
       String st;
       // Condition holds true till
       String heading = br.readLine();
       while ((st = br.readLine()) != null)
       str.add(st);
    //    sort string
    Collections.sort(str);
    // Print the string
    System.out.println("Contents ordered alphabetically:");
    System.out.println(heading); 
    for (String s : str) 
    { 
        System.out.println(s); 
    }
    // System.out.println(str);
    br.close();
} catch (IOException e) {
    System.out.print("An Error Occured.");
}
menu1();
}
void nametraversal(){

}

void populationtraversal(){

}

void menu2()
{
char k;
//giving option to the user for their choice
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\t\t\t  LA CITY DATABASE \n\n");    
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
System.out.print("\t\t\t\t\t________________________________________________________________________________________ \n");
System.out.print("\t\t\t\t\t|                                                                                       |\n");
System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n");
System.out.println("\t\t\t\t| 1 >> Search by Name                                                                   |");
System.out.println("\t\t\t\t| 2 >> Search by Population Range                                                       |");   
System.out.println("\t\t\t\t| 3 >> Exit to top menu                                                                 |");
System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n\n");
System.out.print("\t\t\t\t\t\tEnter your choice: ");
k=scan.next().charAt(0);
//if inputed choice is other than given choice
switch(k)
{
case '1': search();
break;
case '2': search();
break;
case '3': menu();
break;
default: System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
  System.out.print("\t\t\t\t\t\tTry again...........\n\n");
  menu();
}
menu();
}

private void nametraversal1() {
}
void town()
{
System.out.print("Enter the town name: ");

String LATowns =scan.next();
getCurrentTimeUsingDate();  

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(LATowns+".txt");

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    
            // Note that write() does not automatically
            // append a newline character.
            System.out.print("\n********************************************************************\n");
            System.out.print("\nName : ");name=readString();bufferedWriter.write("Name : "+name);
            bufferedWriter.newLine();
            System.out.print("\nlatitude : ");latitude=scan.nextDouble();bufferedWriter.write("latitude : "+latitude);
            bufferedWriter.newLine();
            System.out.print("\npopulation : ");population=scan.nextInt();bufferedWriter.write("population : "+population);
            bufferedWriter.newLine();
            System.out.print("\nlongitude : ");longitude=scan.nextDouble();bufferedWriter.write("longitude : "+longitude);
            bufferedWriter.newLine();
            System.out.print("\n********************************************************************\n");
            bufferedWriter.write("\n********************************************************************\n\n");
            bufferedWriter.newLine();System.out.print("\nInformation Saved Successfully\n");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) 
	{
            System.out.println("Error writing to file '"+ LATowns +"'");
        }
    pressAnyKeyToContinue();
}

void population()
{
System.out.print("Enter the town name: ");

String LATowns =scan.next();
getCurrentTimeUsingDate();  

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(LATowns+".txt");

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
            // Note that write() does not automatically
            // append a newline character.
            System.out.print("\n********************************************************************\n");
            System.out.print("\nName : ");name=readString();bufferedWriter.write("Name : "+name);
            bufferedWriter.newLine();
            System.out.print("\nlatitude : ");latitude=scan.nextInt();bufferedWriter.write("latitude : "+latitude);
            bufferedWriter.newLine();
            System.out.print("\npopulation : ");population=scan.nextInt();bufferedWriter.write("population : "+population);
            bufferedWriter.newLine();
            System.out.print("\nlongitude : ");longitude=scan.nextInt();bufferedWriter.write("longitude : "+longitude);
            bufferedWriter.newLine();
            System.out.print("\n********************************************************************\n");
            bufferedWriter.write("\n********************************************************************\n\n");
            bufferedWriter.newLine();System.out.print("\nInformation Updated Successfully\n");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) 
    {
            System.out.println("Error writing to file '"+ LATowns +"'");
        }
    pressAnyKeyToContinue();
}

void insert()
{
File file = new File("LATowns.txt");
String name;
String latitude;
String longitude;
String population;
String s = System.lineSeparator();
// enter filename along with its extension
System.out.print("Enter the Name of City to Insert: ");
Scanner sc1 = new Scanner(System.in);
name = sc1.next(); 
System.out.print("Enter the Latitude: ");
latitude = sc1.next(); 
System.out.print("Enter the Logitude: ");
longitude= sc1.next();
System.out.print("Enter the Pupulation: "); 
population = sc1.next();

String line = name+"        "+latitude+"        "+longitude+"       "+population;
try {
    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
    bw.append(s + line);
    bw.close();
} catch (IOException e) {
    System.out.println(e.getMessage());
}
menu();
}

void distance()
{
System.out.print("Enter the town name: ");

String LATowns =scan.next();
getCurrentTimeUsingDate();  

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter("LATowns.txt");

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
           int lat1,lat2;  
           int lon1,lon2;
           double distance;
           Scanner sc=new Scanner(System.in);
           System.out.println("enter one point i.e., lat1");
           lat1=sc.nextInt();
           System.out.println("enter lon1 point");
           lon1=sc.nextInt();
           System.out.println("enter lat2 point");
           lat2=sc.nextInt();
           System.out.println("enter lon2 point");
           lon2=sc.nextInt();
           distance=Math.sqrt((lat2-lat1)*(lat2-lat1) + (lon2-lon1)*(lon2-lon1));
           System.out.println("distancebetween two points is:"+distance);
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) 
    {
            System.out.println("Error writing to file '"+ LATowns +"'");
        }
    menu();
}

public static void replaceSelected(String replaceWith, String type) {
    try {
        String s = System.lineSeparator();
        String text;
        // enter filename along with its extension
        System.out.print("Enter text to replace with: ");
        Scanner sc1 = new Scanner(System.in);
        text = sc1.next(); 
        // input the file content to the StringBuffer "input"
        BufferedReader file = new BufferedReader(new FileReader("LATowns.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String line;

        while ((line = file.readLine()) != null) {
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();
        String inputStr = inputBuffer.toString();

        System.out.println(inputStr); // display the original file for debugging

        // logic to replace lines in the string (could use regex here to be generic)
        if (type.equals("0")) {
            inputStr = inputStr.replace(replaceWith + "1", replaceWith + "0"); 
        } else if (type.equals("1")) {
            inputStr = inputStr.replace(replaceWith + text, replaceWith + text);
        }

        // display the new file for debugging
        System.out.println("----------------------------------\n" + inputStr);

    } catch (Exception e) {
        System.out.println("Problem reading file.");
    }

}
void update()
{
    String name;
    // enter filename along with its extension
    System.out.print("Enter the Name of City to Update: ");
    Scanner sc1 = new Scanner(System.in);
    name = sc1.next(); 
    replaceSelected(name, "1"); 
    menu();
}
void delete()
{
    String fname;
    // enter filename along with its extension
    System.out.print("Enter the Name of City to Delete: ");
    Scanner sc1 = new Scanner(System.in);
    fname = sc1.next(); 
    File file = new File("LATowns.txt");
    File tmp = new File(file+"deleted");
    File tmp2 = new File("deleted"+file);
    try (BufferedReader in = new BufferedReader(new FileReader(file));
         PrintWriter pw = new PrintWriter(new FileWriter(tmp))) {
            String st;
            // Condition holds true till
            while ((st = in.readLine()) != null)
    
            if(st.indexOf(fname)!=-1) {
                pw.println(st);
             }
    } catch (IOException e) {
    System.out.print("An Error Occured.");
    }
         tmp.renameTo(tmp2);
    
  menu();
}

void search()
   {
    File file = new File("LATowns.txt");
    String fname;
    // enter filename along with its extension
    System.out.print("Enter the Name of City to Search: ");
    Scanner sc1 = new Scanner(System.in);
    fname = sc1.next(); 
    ArrayList<String> str = new ArrayList<>(); 
    try (BufferedReader br= new BufferedReader(new FileReader(file))) {
        // Declaring a string variable
        String st;
        // Condition holds true till
        String heading = br.readLine();
        while ((st = br.readLine()) != null)

        if(st.indexOf(fname)!=-1) {
            str.add(st);
         }
     // Print the string
     System.out.println("Found City:");
     System.out.println(heading); 
     if(str.isEmpty()){
        System.out.println("No such City:");
     }
     for (String s : str) 
     { 
         System.out.println(s); 
     }
     // System.out.println(str);
     br.close();
 } catch (IOException e) {
     System.out.print("An Error Occured.");
 }
       menu();
}


void exit()
{
System.out.print("\t\t\t\t\t\n\n\n\n\t\t\t\t\t");
System.out.print("\t\t\t\t\t ____________________________________________________________________________________\n");
System.out.print("\t\t\t\t\t|                                           		                                |\n");
System.out.print("\t\t\t\t\t|                                           		                                |\n");
System.out.print("\t\t\t\t\t|                               THANK YOU FOR USING                                 |\n");
System.out.print("\t\t\t\t\t|                                                                                   |\n");
System.out.print("\t\t\t\t\t|                            LA CITY DATABASE                                       |\n");
System.out.print("\t\t\t\t\t|                                                                                   |\n");
System.out.print("\t\t\t\t\t|                                                                                   |\n");
System.out.print("\t\t\t\t\t|___________________________________________________________________________________|\n");
System.out.print("\t\t\t\t\t\n\n\n\n\t\t\t\t\t");
System.exit(0);
}
void info()
{
	System.out.println("\n\nLA CITY DATABASE ");
	System.out.print("\t\t\t\t__________________________________________________________________________________________________________________________________\n");
	System.out.print("\t\t\t\t\t      Options		                                 | Description                                       \n");
	System.out.print("\t\t\t\t__________________________________________________________________________________________________________________________________\n");
	System.out.println("\t\t\t\t 1 >> Display the information of all the cities      |  Display the information of all the cities  .");
	System.out.println("\t\t\t\t 2 >> Search a city                                  |Search a city ");
	System.out.println("\t\t\t\t 3 >> Insert a city                                  | Insert a city  ");
	System.out.println("\t\t\t\t 4 >> Delete a city                                  | Delete a city details.");        
	System.out.println("\t\t\t\t 5 >> Update the population of a city 			     | Updates  the population of a city.");    
	System.out.println("\t\t\t\t 6 >> Find the distance between two cities		     | Helps to  Find the distance between two cities      .");
    System.out.println("\t\t\t\t 7 >> Find nearby cities                             | Provide the nearby cities.");    
    System.out.println("\t\t\t\t 8 >> Exit the City Database                         | Exits the application.");
    System.out.print("\t\t\t\t__________________________________________________________________________________________________________________________________\n");
    pressAnyKeyToContinue();
}
}
public class LACity
{
public static void main (String args[])
{
  Info i=new Info();
  i.menu();
  i.info();
}
}
