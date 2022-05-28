package com.jsclasses.datastructure;

public class ArrayBinaryTree {
	
	static int root = 0; 
    static int[] array; 
    
    ArrayBinaryTree(int size) {
    	array = new int[size];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayBinaryTree obj = new ArrayBinaryTree(12);
		
        obj.createRoot(21); 
        obj.setLeft(1, 0); 
        obj.setRight(33, 0); 
        obj.setLeft(11, 1); 
        obj.setRight(1111, 1); 
        obj.setLeft(45, 2); 
        obj.setRight(145, 2); 
        obj.setLeft(37, 3);
        obj.setRight(142, 3);
        obj.setLeft(22, 4);
        obj.setRight(14, 4);
        obj.printTree(); 

	}
      
    /*create root*/
    public void createRoot(int data) { 
        array[0] = data; 
    } 
  
    /*create left son of root*/
    public void setLeft(int data, int root) { 
        int temp = (root * 2) + 1; 
  
        if(array[root] == 0){ 
            System.out.printf("Can't set child at %d, no parent found\n", temp); 
        }else{ 
            array[temp] = data; 
        } 
    } 
  
    /*create right son of root*/
    public void setRight(int data, int root) 
    { 
        int temp = (root * 2) + 2; 
  
        if(array[root] == 0){ 
            System.out.printf("Can't set child at %d, no parent found\n", temp); 
        }else{ 
            array[temp] = data; 
        } 
    } 
  
    public void printTree() 
    { 
        for (int i = 0; i < array.length; i++) { 
            if (array[i] != 0) 
                System.out.print(array[i] + " "); 
            else
                System.out.print("-X"); 
              
        } 
    }

}
