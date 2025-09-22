# Process-Creation-Hiearchy-
Download the Process.java file from Canvas and include it into the same directory where Project1.java will be located. The Process data type from this file is required to be used within this project.
Declare two global variables - a Scanner object input and a Process object array table - these will be used throughout the various methods of this project.
The user assigns table with a length of n - using indices 0 to n-1 (n must be 1 or higher in value).
All user-typed inputs in this project will be error checked for data type, input flushing, and valid data. Errors from the main method result in the program terminating. Errors from the main loop result in the next loop occurring. Errors from the other methods result in a return to the main method's loop.
Each process object in the array will be constructed within a loop, and will use the following variables throughout the project:
parentIndex - a process index corresponding to the parent of the current process
firstChildIndex - a process index corresponding to the first child of the current process
youngerSiblingIndex - a process index corresponding to the process that shares the same parent as the current process, but was created after the current process
All processes connect to one another through index values, and not through Process variables or dynamic arrays. These indices must be used throughout the project.
After constructing the process array, process 0 has its parent index set to itself (0), therefore activating this process as the "root" of the hierarchy tree.
Once table is initialized, a loop statement will act as the main program control. This loop will prompt the user for an integer value as a menu selection. The last selection will exit the loop, with an else (or default) case detecting out-of-bounds selections and repeating the loop.
Once the loop has been completed, the program ends.
 

The necessary methods (not including main) are simplified as follows:
printHierarchy() - displays each process that is active in the hierarchy from table (having a parent index that isn't -1). Every row represents a process, and every column represents a separate variable (see sample output below for examples).
addProcess() - prompts the user for parentIndex (between 0 to n-1) to represent the parent process located in table (the process must also be active in the hierarchy). The method then activates an inactive process from table represented as childIndex - this process is then added into the hierarchy as a child of the parent process by performing the following actions:
Find the first available entry in table (having a parent index of -1) to designate as childIndex. If no entries are available, then table is completely full, resulting in an error message.
Set the parent index of table[childIndex] as parentIndex.
If the parent process has no pre-existing children, then set the first child index of table[parentIndex] as childIndex.
If the parent process has one or more pre-existing children, then the index of the youngest sibling process youngestIndex must be found. This can be done by finding the first child index from table[parentIndex], and then recursively searching for the younger sibling index of each sibling process.
Once the youngest sibling process is found (itself having a younger sibling index of -1), then childIndex can now be assigned as the younger sibling index within table[youngestIndex] (this effectively makes the child process the new youngest sibling process).
Regardless of whichever scenario occurs, a message printing the success of the operation will conclude the method.
removeProcess() - prompts the user for parentIndex (between 0 to n-1) to represent the parent process located in table (the process must also be active in the hierarchy).
The base method calls upon the recursive method, with the parent process' first child index representing the targeted process for removal (not the parent process itself).
After the recursive method call finishes, the value of the parent process' first child index is initialized to -1, followed by a message that prints the success of the operation.
removeProcessRecursively() - removes processes from the hierarchy, starting with the process represented by the input argument currentIndex.
First, check to see if currentIndex is valid or invalid. If it is invalid (-1), then the method terminates immediately (acting as the recursion's base case).
If currentIndex is valid (not -1), then call the recursive method on the younger sibling index of table[currentIndex] (this continues until the youngest sibling process is reached).
Next, call the recursive method on the first child index of table[currentIndex] (this means that any given process' siblings will be destroyed before its children are).
Once the recursive travel returns back to the current process, assign -1 into all three variables of table[currentIndex] (this includes parentIndex, firstChildIndex, and youngerSiblingIndex).
