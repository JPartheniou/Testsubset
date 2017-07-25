import java.util.InputMismatchException;
import java.util.Scanner;

public class Testsubset {
	static Scanner input=new Scanner(System.in);
	
	public static void showSubSet(int set[], int subSet[], int start,
			int index, int sizeofSubset){
		if(index == sizeofSubset){
			for(int j=0; j<sizeofSubset; j++){
				System.out.print(subSet[j]);
				System.out.print(" ");
			}
			System.out.println();
			return;
		}
		int sizeofSet = set.length;
		for(int i=start; i<sizeofSet; i++){
			subSet[index] = set[i];
			showSubSet(set, subSet, i+1, index+1, sizeofSubset);	
		}}
	public static void main(String args[]){
		int length=0;
		boolean error = false;
		System.out.println("------------------------------------------------------");
    	System.out.println("| Welcome to John's SubSets Tester!                  |");
    	System.out.println("| The numbers that you will place must be unique!    |");
    	System.out.println("| The size of the subset must be greater than 0      |");
    	System.out.println("|     and smaller or equal to the size of the set!   |");
    	System.out.println("------------------------------------------------------");
		try{
		System.out.print("How many numbers do you want to insert: ");
		length=input.nextInt();
		}catch(InputMismatchException exception){
			System.out.println("This is not an integer");
			error = true;
		}
		int number = 0;
		int set[] = new int [length];
		if(!error){
	        for(int i=1; i<=length; i++){
	        	try{
	        	System.out.print("Number " + i + ": ");
	    		number=input.nextInt();
	        	}catch(InputMismatchException exception){
	    			System.out.println("This is not an integer");
	    			error = true;
	    			break;
	    		}
	    		set[i-1]=number;
	        }
		}
        int sizeofSubset = 0;
        if(!error){
	        try{
	        System.out.print("What is the size of SubSet? ");
			sizeofSubset=input.nextInt();
	        }catch(InputMismatchException exception){
				System.out.println("This is not an integer");
				error = true;
			}
        }
		int subSet[] = new int[sizeofSubset];
		
		boolean duplicates = false;
		int checking;
		for (int i=0; i<length;i++){
			checking = set[i];
			for(int j=i+1; j<length; j++){
				if(checking == set[j]){
					duplicates = true;
				}
			}			
		}
		if(!error){
			if(duplicates){
				System.out.println("You have duplicate values. Please try again!");
			}else if(length<sizeofSubset){
				System.out.println("The size of subset you have set is larger than the amount of integers you have inserted. Please try again!");
			}else if(sizeofSubset < 1){
				System.out.println("The size of subset must be greater than 0. Please try again!");
			}else{
				long startTime = System.nanoTime();
				long time1 = System.currentTimeMillis();
				showSubSet(set, subSet, 0, 0, sizeofSubset);
				long time = System.nanoTime() - startTime;
				long time2 = System.currentTimeMillis() - time1;
				long memoryused = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
				System.out.println("Duration of execution (in nanoseconds): " + time); 
				System.out.println("Duration of execution (in milliseconds): " + time2);
		        System.out.println("Memory used for the execution: " + memoryused);     }}}}
