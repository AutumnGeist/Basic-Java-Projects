/* Marilyn Holland, 6/12/19, IT106 2B1, Programming Assignment 2
This program calculates how much it would cost for one dog to stay at the dog hotel for a certain number of days. The cost per day is determined by the dog's weight, 
so selective statements must be used to properly categorize the daily cost.The total cost is then calculated by multiplying the daily cost by the number of days of the stay.
The required input from the user includes the dog's name, the dog's weight, and how many days they'll be staying.
The expected output of the program would be all of the input data, along with the total cost of the stay. */ 

import javax.swing.JOptionPane;
public class DogHotel {
   public static void main (String [] args) {

      boolean valid1 = true;
      String dogName = JOptionPane.showInputDialog("What is your dog's name?");
      //validate dog's name
      if (dogName.equals(""))  {   
         valid1 = false;
      } 
      if (valid1 == true) {  
         double dogWeight = Double.parseDouble(JOptionPane.showInputDialog("How many pounds does your dog weigh?"));
         //validate dog's weight
         if (dogWeight > 0.0) {  
            int numDays = Integer.parseInt(JOptionPane.showInputDialog("How many days will your dog be staying?"));
            //validate number of days
            if (numDays > 0) {   
 
                  //declare and initialize variables
                  double dayCost = 0;  
                  double totalCost = 0;
                  
                  //multi-case selective statement used to categorize dog by weight
                  if (dogWeight<= 12) {     
                      dayCost = 18.95;
                  } else if (dogWeight>12 && dogWeight<=23) {
                     dayCost = 28.95;
                  } else if (dogWeight>23 && dogWeight <=33){ 
                     dayCost = 38.95;
                  } else if (dogWeight > 33) {
                     dayCost = 48.95;
                  }
                  //total cost calculated
                  totalCost = numDays*dayCost;    
                  //Output
                  JOptionPane.showMessageDialog(null, "Dog's name: " + dogName + '\n' + "Dog's weight: " + dogWeight + " lbs" + '\n' + "Number of days of stay: " + numDays
                   + '\n' + String.format("Total cost of stay: $%.2f", totalCost));
             }
            
              else {
                  //Error message for invalid number of days
                  JOptionPane.showMessageDialog(null,"Error! You must enter a number higher than 0! Please try again!");  
              }
           }
          else {
                //Error message for invalid weight
               JOptionPane.showMessageDialog(null,"Error! You must enter a valid weight! Please try again!");   
          } 
       }  
      else {
         //Error message for no name entered
         JOptionPane.showMessageDialog(null,"Error! You must enter a name! Please try again!");          
      }        
  }     
}