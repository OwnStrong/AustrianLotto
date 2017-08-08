/*
Author: Own Daghagheleh
Problem statement: Solving Austrian Lotto "6 aus 45" problem, gathered from https://community.topcoder.com/stat?c=problem_statement&pm=1934 on 18/07/2017
Class Description: Main Driver for AustrianLotto class
*/
package com.distributed.austrianlotto;
import static com.distributed.austrianlotto.AustrianLotto.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class AustrianLottoDriver {
    public static void main(String[] args) throws InterruptedException{
       
        //Variables 
        boolean term = false;
        final int DRAWING_SIZE = 6;
        int num_of_picks;
        Random rand = new Random();
        
        //Use Java Random method to generate 6 numbers in range 1-45 for system draw
        String draw="";
        for(int z=0; z<DRAWING_SIZE; z++){
            int ii= rand.nextInt(45)+1;
            if(z==DRAWING_SIZE-1){
                draw=draw+String.valueOf(ii);
            }else{
                draw=draw+String.valueOf(ii)+" ";
            }
        }
        //Uncomment to print system draw
        //System.out.println(draw);
        //Keep the program running until user terminate 
        while(!term){
            try{
                System.out.print("Please enter any key to start the game, Or type EXIT to exit....");
                Scanner scanner = new Scanner(System.in);
                //If user enter exit, terminate the program
                if (scanner.nextLine().equalsIgnoreCase("exit")){
                   term=true;
                   break;
                }else{
                   System.out.println("Please enter your pick/picks: ");
                   System.out.println("System automatically generating picks....");
                   //Sleep for 1000ms to make the execution realistic 
                   Thread.sleep(1000);
                   //Use Java Random method to define number of picks in each pick
                   num_of_picks = rand.nextInt(50)+1;
                   String[] picks = new String[num_of_picks];
                   //Construct a pick from random numbers
                   for(int i=0; i<picks.length; i++){
                       String pick="";
                       for(int k=0; k<DRAWING_SIZE; k++){
                            int ii= rand.nextInt(45)+1;
                            if(k==DRAWING_SIZE-1){
                                pick=pick+String.valueOf(ii);
                            }else{
                                pick=pick+String.valueOf(ii)+" ";
                            }
                       }
                       picks[i]=pick;
                   }
                  //Resolve Austrian Lotto problem by using AustrianLotto evaluate static method 
                   int[] result = evaluate(draw, picks);
                   System.out.println("System generates the following picks: ");
                   System.out.println(Arrays.toString(picks)); 
                   System.out.println("\nCalculating the result...");
                   //Sleep for 1000ms to make the execution realistic 
                   Thread.sleep(1000);
                   System.out.println(Arrays.toString(result)); 
               }
            //Skip the iteration of loop if the user enter illegal input
            }catch(IllegalArgumentException e){
                continue;
            }  
        }  
    }
}
