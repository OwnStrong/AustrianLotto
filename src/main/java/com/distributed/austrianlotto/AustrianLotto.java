/*
Author: Own Daghagheleh
Problem statement: Solving Austrian Lotto "6 aus 45" problem, gathered from https://community.topcoder.com/stat?c=problem_statement&pm=1934 on 18/07/2017
Class Description: Solving Austrian Lotto "6 aus 45" problem
*/
package com.distributed.austrianlotto;
import java.util.Arrays;

public class AustrianLotto {
    
    //Austrian Lotto constraints variables
    final static int MIN_NUM_PICKS = 1;
    final static int MAX_NUM_PICKS = 50;
    final static int DRAW_SIZE = 6;
    final static int DRAW_MIN = 1;
    final static int DRAW_MAX = 45;
    final static int RESULT_SIZE = 7;
    final static int DRAW_MIN_NUM_CHART = 11;
    final static int DRAW_MAX_NUM_CHART = 17;
    
    //Evaluate method, gets a drawing and picks list and return an integer list of result
    public static int[] evaluate(String drawing, String[] picks){
        
        int number_of_maches;
        int[] result = new int[RESULT_SIZE];
        //Convert the drawing to list of integer
        int[] drawing_int = str_to_int_list(drawing);
   
        //Validate drawing and picks input
        validate(drawing);
        validate(picks);
        
        //Out loop to inspect each pick in list of picks
        for(int i=0; i<picks.length; i++){
            number_of_maches = 0;
            //Validate each pick and convert it to list of integer
            validate(picks[i]);
            int[] pick_int = str_to_int_list(picks[i]);
            
            //Do binary search and find out how many draw element are existed in a pick
            for(int k=0; k<pick_int.length; k++){
                int search_draw_num =  drawing_int[k];
                if(binary_search(search_draw_num, pick_int)){
                    number_of_maches++;
                }
            }
            //Increment the number of matches element
            //If no match been found, increment the 0 element
            result[number_of_maches]++;
        }
        
        return result;
    }
    //str_to_int_list method converts list of draw or pick, from String to Integer data type 
    public static int[] str_to_int_list(String input){
        
        int[] result = new int[DRAW_SIZE];
        validate(input);
        String[] drawingTokens = input.split(" ");
        
        //Check if draw or pick has exactly 6 elements
        if(drawingTokens.length != DRAW_SIZE){
            System.out.println("Lotto should contain exactly 6 number");
            throw new IllegalArgumentException("Lotto should contain exactly 6 number");
        }else{
            //Convert each element from String to Integer
            for(int i=0; i<DRAW_SIZE ;i++){
                int to_int = 0;
                //Check if the element is integer 
                try{
                    to_int = Integer.parseInt(drawingTokens[i]);
                }catch(IllegalArgumentException e){
                    System.out.println("Lotto must contains only numbers");
                }
                //Each if each Lotto number is in range 1-45
                if((to_int < DRAW_MIN) || (DRAW_MAX < to_int)){
                    System.out.println("Lotto numbers must be between 1 and 45");
                    throw new IllegalArgumentException("Lotto numbers must be between 1 and 45,inclusive");
                }else{
                    result[i]= to_int;
                }
            }
        }
        return result;  
    }
    //Do a binary search on list of integer
    public static boolean binary_search(int num, int[] num_list){
        Arrays.sort(num_list);
        int start = 0;
        int end = num_list.length - 1;
        while(start <= end){
            int middle = start + (end - start)/2;
            
            if(num < num_list[middle]){
                end = middle - 1;
            }else if(num > num_list[middle]){
                start = middle +1;
            }else{
                return true;
            }
        }     
      return false;          
    }
    //Validate each pick for correct structure & spacing
    private static void validate(String drawing){
        if (drawing == null) {
            throw new IllegalArgumentException("Lotto cannot be null");
        }else if((drawing.length()<DRAW_MIN_NUM_CHART) || (DRAW_MAX_NUM_CHART<drawing.length())){
            System.out.println("Lotto should contain 6 number, each separated by exactly one single space and have no leading zeros");
            throw new IllegalArgumentException("Lotto should contain 6 number, each separated by exactly one single space and have no leading zeros");
        }
    }
    //Validate picks and check if number of pick are in range 1-50
    private static void validate(String[] picks){
        if (picks == null){
            throw new IllegalArgumentException("Picks cannot be null");
        }else if( (picks.length < MIN_NUM_PICKS) || MAX_NUM_PICKS < (picks.length)){
            throw new IllegalArgumentException("Picks must be between 0 and 50 ,inclusive");
        }
    }
}