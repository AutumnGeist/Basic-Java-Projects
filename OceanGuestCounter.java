/*Marilyn Holland, 6/27/19, IT106 2B1, Programming Assignment 4
This program is intended to help a lifeguard keep a running tally of the total number of guests inside of their section.
This is done by keeping track of the number of people entering and leaving, and making sure that the incoming number of people does not exceed the max capacity of 68 people.
Validation has been added for both inputs, to make sure that they are both valid integer numbers for the scenario. I also added a logic validation to make sure if guests are leaving, 
the guest number is not greater than the total, as this would not be possible, and would lead to a negative number for the total. 
If a coming person or group number is about to exceed the max limit, a message denying entry will be displayed.
I also added a message to be displayed when the max limit has been reached, as this does not deny entry, but does signal that the program will end.
The program will continue to loop with people coming and going until the max number is (or is about to be) reached.*/

import javax.swing.JOptionPane;

public class OceanGuestCounter {
   public static void main (String [] args) {
      final int MAX = 68;
      int total = 0;
      int status = 0;
      int guestNum = 0;
      boolean maxReached = false;
      //#1 loop until max capacity has been reached or is about to be reached
      do{
         // #2 loop to check is guestNum leaving is greater than current total of guests
         do{ 
            // #3 loop to validate user input for guestNum
            do{
               try{
                  guestNum = Integer.parseInt(JOptionPane.showInputDialog("Enter number of guests: "));
               }catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(null,"Error! You must enter an integer number!");
               }
               if ((guestNum<=0) || (guestNum>MAX)) {
                  JOptionPane.showMessageDialog(null,"You either entered 0, or a number larger than our full capacity of 68. Please try again.");
               }
            //#3 condition
            }while((guestNum<=0) || (guestNum>MAX));
            //#4 loop to validate user input for status (leaving or entering)
            do{
               try{
                  status = Integer.parseInt(JOptionPane.showInputDialog("Enter 0 if leaving, or 1 if entering the beach: "));
               }catch(NumberFormatException e){
                  JOptionPane.showMessageDialog(null, "Error! You must enter a number!");
               }
               if (status!=0 && status!=1) {
                  JOptionPane.showMessageDialog(null,"You must enter 0 or 1. Please try again!");
               }
            //#4
            }while(status!=0 && status!=1);
            //Checks to see if guestNum leaving is greater than the current total of guests
            if (status==0 && total-guestNum<0) {
               JOptionPane.showMessageDialog(null, "The number of guests leaving, is greater than the current total of guests, which is not possible! Please try again.");
            }
         //#2
         }while((status==0) && (total-guestNum<0));
         //checks to see if guest(s) are leaving; subtracts guestNum from total
         if (status==0) {
            total = total-guestNum;

         }else{
            //checks to see if guestNum will hit max capacity, ends program if true
            if (total+guestNum > MAX) {
               JOptionPane.showMessageDialog(null, "Entry denied! The maximum capacity will been reached!");
               maxReached = true;
            }
            //if not leaving or exceeding capacity, add guestNum to total
            else {
               total = total + guestNum;
            }
         }
         //This is added to signal that the maximum capacity has been reached and thus the program will end
         if (total == MAX) {
            JOptionPane.showMessageDialog(null, "The maximum capacity has been reached.");
         }
         //output current total of guests
         JOptionPane.showMessageDialog(null,"The current total of guests is: " + total);   
      //#1
      }while((maxReached==false) && (total<MAX));
      
   }
}