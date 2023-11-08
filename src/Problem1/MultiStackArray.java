package Problem1;

import com.sun.source.doctree.SinceTree;

public class MultiStackArray {
    //Array size
    private int arraySize;

    //Stacks sizes inside array
    private int stacksSizes;

    //array that contains stacks
    private int[] arrayStacks;

    //array of tops
    private int[] arrayTops;

    public MultiStackArray(int arraySize){
        if(arraySize%4 != 0){
            System.out.println("ERROR 404");
        }
        else{
            //classic constructor >D
            this.arraySize= arraySize;
            this.stacksSizes= arraySize/4;
            this.arrayStacks=new int[this.arraySize];
            //For this problem number of tops is set to be 4
            this.arrayTops=new int[4];

            //now every time this iterates we need to check what is top in every stack

            for(int i=0; i<4; i++){
                this.arrayTops[i]=i*this.stacksSizes-1;
            }

        }
    }

    //Before creating push and pop method, we need to create two new methods
    //isFull and IsEmpty because of handling exceptions and overflow

    public boolean isFull(int indexOfStack){
        //This method determines if a specific stack is full by checking if its top
        //position matches the maximum position it should reach when the stack is full.
        return (this.arrayTops[indexOfStack]==this.stacksSizes*(indexOfStack+1)-1);
    }
    public boolean isEmpty(int indexOfStack){
        //This method checks if a specific stack is empty by comparing the current top
        //position of the stack with the position it would be
        // if the stack were completely empty (one less than the stack's size).
        return (this.arrayTops[indexOfStack]==this.stacksSizes-1);
    }

    public void push(int indexOfStack, int key){
        //We need to check whether stack si full, if it is we cant add new key
        if (this.isFull(indexOfStack)) {
            System.out.println("ERROR 420 - There has been overflow");
        }
        else{
            //we are pushing new stack and stacking values
            this.arrayStacks[++this.arrayTops[indexOfStack]]=key;
        }
    }

    public int pop(int indexOfStack){
       //We need to check whether stack is empty because if that we can't pop any value
        if (this.isEmpty(indexOfStack)){
            System.out.println("ERROR 0311");
        }
        //We are popping last value from stack
        return this.arrayStacks[this.arrayTops[indexOfStack]--];
    }

    public int peek(int indexOfStack){
        //we need to get peek to last value of required stack in array
        //if stack is empty we can't get peek to last value

        if(this.isEmpty(indexOfStack)){
            System.out.println("ERROR 0406");
        }
        return this.arrayStacks[this.arrayTops[indexOfStack]];
    }

    //Wee need to display values in stack

    public void displayValues() {
        for (int i = 0; i < this.arraySize; i++) {
            if (i % 5 == 0) {
                switch (i / 5) {
                    case 0:
                        System.out.print("First Stack: ");
                        break;
                    case 1:
                        System.out.print("Second Stack: ");
                        break;
                    case 2:
                        System.out.print("Third Stack: ");
                        break;
                    case 3:
                        System.out.print("Fourth Stack: ");
                        break;
                }
            }

            System.out.print(" " + this.arrayStacks[i] + " ");

            if ((i + 1) % 5 == 0) {
                System.out.println(); // Move to the next row after every 5 elements
            }
        }
        System.out.println(); // Ensure a new line at the end

        System.out.println("Full array:"); // Ensure a new line at the end
        for(int i=0; i<this.arraySize; i++){
            System.out.print("|");
            System.out.print(this.arrayStacks[i]);
        }
    }


}
