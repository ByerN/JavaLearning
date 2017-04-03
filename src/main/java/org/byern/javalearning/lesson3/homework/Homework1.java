package org.byern.javalearning.lesson3.homework;

/**
 * Created by ByerN on 22.02.2017.
 * Edited by Konrad
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
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[(j % 10)]);
				Thread.sleep(100);
			}
		}       

    }
}
