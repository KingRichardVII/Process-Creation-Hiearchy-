//Richard Phan
//Comp 322 Fall 2025
//Project 1

import java.util.Scanner;

public class Project1 {
	//global variables
	private static Scanner input = new Scanner (System.in);
	private static Process[] table;
	
	//Main method
	public static void main(String[] args) {
		//enter the table size
		System.out.println("Enter the table size: "); // == COUT
		if (!input.hasNextInt()) {//Data Type check //! == NOT
			System.out.println("Invalid input.");
			System.exit(0); //== return 0;
		} //end of input validation
		int tableSize = input.nextInt();
		input.nextLine(); //flush input to delete empty scanner 
		if (tableSize <= 0) { //Valid data check
			System.out.println("Invalid table size.");
			System.exit(0); 
		}
		//create the process table
		table = new Process[tableSize];
		for (int i = 0; i < table.length; i++) {
			table[i] = new Process(); //finish constructor
		}
		//initialize the first process in the table
		table[0].setParentIndex(0);
		
		//main loop
		int option = 0; //Any value other than 4 (4 ends the program
		while (option !=4) {
			System.out.println();
			System.out.println("1) Print Hiearchy from table");
			System.out.println("2) Add child process to hierarchy");
			System.out.println("3) Remove a process's descendants from the hierarchy");
			System.out.println("4) Quit program");
			System.out.println("Enter Selection"); //case for invalid option, loop repeats harmlessly
			if (input.hasNextInt()) {//data type check
				option = input.nextInt();
			}else {
				option = 0; // any value other than 1,2,3,4
			}
			input.nextLine(); //input flushing
			switch (option) {
				case 1:
					printHiearchy();
					break;
				case 2:
					addProcess();
					break;
				case 3: 
					removeProcess();
					break;
				case 4: 
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Invalid option, try again");
			}//End of Switch Statement
		}//end of main loop
	}//end of main method
	
	//print Hiearchy
	public static void printHiearchy() {
		//Print the header row
		System.out.println("Index\tParent\tFirst\tYounger");
		//Every valid process as a row
		for (int i = 0; i < table.length; i++) {
			if (table[i].getParentIndex() == -1) {
				continue;
			}
			System.out.print(i + "\t" + table[i].getParentIndex() + "\t");
			if (table[i].getFirstChildIndex() != -1) {
				System.out.print(table[i].getFirstChildIndex());
			}
			System.out.print("\t");
			if (table[i].getYoungerSiblingIndex() != -1) {
				System.out.print(table[i].getYoungerSiblingIndex());
			}
			System.out.println();
		}
	}//end of print hierarchy
	
	//Add process
	public static void addProcess() {
		System.out.println("add process"); //DEBUG, REMOVE LATER
		
		//enter the parent process index
		System.out.println("Enter the parent process index for the child process:");
		if (!input.hasNextInt()) { //data type check
			System.out.println ("Invalid input");
			input.nextLine(); //input flush
			return;
		}
		int parentIndex = input.nextInt();
		input.nextLine(); //input flush
		if(parentIndex < 0 || parentIndex >= table.length) { //valid data check
			System.out.println("Invalid process index");
			return;
		}
		//is the parent of the parent valid?
		if (table[parentIndex].getParentIndex() == -1) {
			System.out.println ("Process index is not active");
			return;
		}
		//Calc the next available index as the child process index
		int childIndex = 1; //can also be 0
		while (table [childIndex].getParentIndex() != -1) {
			childIndex++;
			if (childIndex == table.length) {
			System.out.println("Unable to assign an index for the child process.");
			return;
			}
		}
		//set parent process index for the child process
		table[childIndex].setParentIndex(parentIndex);
		//set the child process index for the parent process
		if (table[parentIndex].getFirstChildIndex() == -1){
			//assign the child process index as the parent process' first child
			table[parentIndex].setFirstChildIndex(childIndex);
			}
			else {
			//Find the youngest sibling process among the parent process' children
			//Note- start with oldest and travel towards youngest
			int youngestIndex = table[parentIndex].getFirstChildIndex();
			while (table[youngestIndex].getYoungerSiblingIndex() != -1) {
					 youngestIndex = table[youngestIndex].getYoungerSiblingIndex();
			
		}
		
			//Assign the child process index as a the yngst sibling process' younger sibling
			//NOTE - this makes the child process the new youngest sibling process
			table[youngestIndex].setYoungerSiblingIndex(childIndex);
		}
		//confirm the child process was successfully added 
		System.out.println("Process " + childIndex + " was added as a child process " + parentIndex + ".");
	} //end of add process
	
	//remove process
	public static void removeProcess(){
		System.out.println("remove process"); //DEBUG, REMOVE LATER
	} // end of remove process
	
	//remove process recursively
	public static void removeProcessRecursively (int currentIndex) {
		System.out.println("SAMPLE TEXT"); //DEBUG, REMOVE LATER
	}// end of remove process recursively

}//end of class
