/*
*Author: Hussein Sahib
*Date 4/28/2017
*Description: This program is a class to use in PuppyPlay to operate a game. The game goal is to find a lost puppy.
*/
import java.util.*;
public class LostPuppy{//class LostPuppy
   Random rand = new Random();
   private char [][] myHidingPlaces;//building array
   private int myFloorLocation;//hight of building
   private int myRoomLocation;//number of rooms in a floor
   private char myWinner;//winner
   private boolean myFound;//P
   public LostPuppy(int theFloors, int theRooms)//Constructor takes two arguments
   {
      myHidingPlaces = new char [theFloors][theRooms];
      for (int row = 0; row < theFloors; row++){//intilizing array
         for (int column = 0; column < theRooms; column++){
           myHidingPlaces[row][column] = ' '; 
         }
      }
      this.myFloorLocation = rand.nextInt(theFloors-1); //seting random numbers
      this.myRoomLocation = rand.nextInt(theRooms-1);;
      myHidingPlaces[this.myFloorLocation][this.myRoomLocation] = 'P'; 
      myWinner = ' ';
      myFound = false;
   } 
   public boolean roomSearchedAlready(int floor, int room){//checks if the rooms has already been entered
      if(myHidingPlaces[floor][room] != ' ' && myHidingPlaces[floor][room] != 'P'){//checking
         return true;
      }
      else{
         return false;
      }
   }
   public boolean PuppyLocation(int floor, int room){//checks if the puppy is in the entered room
      if(myHidingPlaces[floor][room] == 'P'){//checks if the puppy is there
         return true;//return
      }
      else{
         return false;
      }
   }
   public boolean indicesOK(int floor, int room){//checks if room entered is with in the building range
      if(floor < myHidingPlaces.length && room < myHidingPlaces[0].length){//checks the range
         return true;//return
      }
      else{
         return false;
      }
   } 
   public int numberOfFloors(){//getter method gets the private myFloorLocation
      return myFloorLocation;
   }
   public int numberOfRooms(){//getter method gets the private myRoomLocation
      return myRoomLocation;
   }
   public boolean searchRoom(int floor, int room, char plyr){//set the array to have the player number in the array if they lose else sets myWinner to winner.
      if(myHidingPlaces[floor][room] == 'P'){
         myWinner = plyr;
         return true;
      }
      else{
         myHidingPlaces[floor][room] = plyr;
         return false;
      }
   }
   public String toString(){//return out put String
      String s = "";//the string s
      int floorleng = myHidingPlaces.length;
      int roomleng = myHidingPlaces[0].length;  
      for(int head = 0; head < roomleng; head++){//header line
         s += "___" ;
      }
         s += "\n";//new line
      for(int floor = (floorleng - 1); floor >= 0; floor--){//prints building floors
         s += "|";
         for(int room = 0; room < roomleng ; room++){//prints rooms
          if (myHidingPlaces[floor][room] == 'P'){
            if (myWinner != ' '){//if the guess is right
               s += "P" + myWinner +  "|";
             }
           else{
            s += "  |";
               }
           }  
          else{  
            s += " " + myHidingPlaces[floor][room];
            s += "|";
            } 
          } 
         s += "\n";//new line
         s +="|";
         for(int room = 0; room < roomleng ; room++){ //makes the rooms larger
            s += "__";
            s+= "|"; 
         }
         s+= "\n"; //new line
      }   
   return s; }
   
}