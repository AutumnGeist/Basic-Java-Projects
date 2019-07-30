/*Marilyn Holland, 7/10/19, IT106 2B1, Programming Assignment 6
This program is intended to create a list of IT students that records their name and number of credits.
Students are only added to the list if they have completed between 30-89 credits.
The user will be prompted to enter students, and if they meet the criteria, their name and credits will be added to parallel arrays.
Once the user has indicated they are done adding students, a list of both arrays should be reviewed, 
and the user will be allowed to removed students from the list. If a name is entered that is not on the list, 
an error message will appear. After each entry, the list should reappear for review. When the user is finished, a report final
of both arrays should be printed.*/

import javax.swing.JOptionPane;

public class StudentArray {
   public static void main (String [] args) {
      final int MAX = 50;
      String name = "", arrayData = "", remove = "";
      int creditNum = 0, currentSize = 0, index = 0;
      String [] names = new String [MAX];
      int [] credits = new int [MAX];
      boolean found = false;

      //loop to fill array, until sentinal is entered to stop
      do{
         //validate student name
         do{
            name = JOptionPane.showInputDialog("Enter student name (-1 if finished): ");
            if (name.equals("")) 
               JOptionPane.showMessageDialog(null, "You must enter a name or -1 to finish!");
         }while(name.equals(""));
         //Continue if user is not finished
         if (!name.equals("-1")){
            //validate credit number
            do{
                  try{
                     creditNum = Integer.parseInt(JOptionPane.showInputDialog("Enter number of credits: "));
                  }catch (NumberFormatException e){
                     JOptionPane.showMessageDialog(null, "Error! You must enter a number!");
                  }if (creditNum<0 || creditNum>160)
                     JOptionPane.showMessageDialog(null, "You must enter a number greater than 0!");
            }while(creditNum<0);
            //if number of credits is between 30-89 credits, add student's name and credits to arrays
            if (creditNum >= 30 && creditNum < 90) {
               names[currentSize] = name;
               credits[currentSize] = creditNum;
               currentSize ++;
            }
         }     
      }while(!name.equals("-1"));
      //Convert arrays into String
      for (int i=0; i<currentSize; i++) {
         arrayData += (names[i] + ": " + credits[i] + '\n');
      }
      //print String array for review
      JOptionPane.showMessageDialog(null, arrayData);
      //allow user to select student to remove from array until -1 is entered
      do{
         remove = JOptionPane.showInputDialog("Enter student name to remove (-1 to finish): ");
         //if the user is not finished removing students
         if (!remove.equals("-1")){
               //loops through names[], resets index & found for each loop
               index=0;
               found = false;
               while (!found && index < currentSize){
                  if(remove.equals(names[index])){
                     found = true;
                     names[index] = names[currentSize-1];
                     credits[index] = credits[currentSize-1];
                     --currentSize;                   
                  }else{
                     index++;
                  }
               }
               //print error message if name is not on list
               if(!found)
                  JOptionPane.showMessageDialog(null, "Error! Name is not on student list!");
               //Convert arrays into String (refreshes each loop)
               arrayData = "";
               for (int i=0; i<currentSize; i++) {
                  arrayData += (names[i] + ": " + credits[i] + '\n');
               }
               //print String array for review
               JOptionPane.showMessageDialog(null, arrayData);
         }
      }while(!remove.equals("-1"));
      //Convert arrays into String
      arrayData = "";
      for (int f=0; f<currentSize; f++) {
         arrayData += ("Name: " + names[f] + ", Credits: " + credits[f] + '\n');
      }
      //print final report with arrays
      JOptionPane.showMessageDialog(null, "ELIGIBLE STUDENTS FOR SURVEY" + '\n' + "Number of students: " + currentSize + '\n' + arrayData);


      
   }
}