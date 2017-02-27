//package org.byern.javalearning.lesson3.homework;

/**
 * Created by ByerN on 22.02.2017.
 */
 
import java.util.Scanner;  
 
public class Homework1 {

    public static void main(String[] args) throws InterruptedException {
        /*
         * Replace if-else construction with looping through array.
         *
         * -play whole animation n-times -> n provided as input
         */
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Provide n: ");
        int n = input.nextInt();
        
        String[] array = {"   x   ", "  xxx  ", " xxxxx ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  "};
        for (int i = 0; i < n; i++) {
			System.out.println(array[(i % 10)]);
			Thread.sleep(300);
		}
            
        //for(int n=0; n< 40; n++){
            //if(n % 10 == 0){
                //System.out.println("   x   ");
            //} else if(n % 10 == 1){
                //System.out.println("  xxx  ");
            //} else if(n % 10 == 2){
                //System.out.println(" xxxxx ");
            //} else if(n % 10 == 3){
                //System.out.println("  xxx  ");
            //} else if(n % 10 == 4){
                //System.out.println("  xxx  ");
            //} else if(n % 10 == 5){
                //System.out.println("  xxx  ");
            //} else if(n % 10 == 6){
                //System.out.println("  xxx  ");
            //} else if(n % 10 == 7){
                //System.out.println("  xxx  ");
            //} else if(n % 10 == 8){
                //System.out.println("  xxx  ");
            //} else if(n % 10 == 9){
                //System.out.println("  xxx  ");
            //}
            //Thread.sleep(300);
        //}

    }

}
