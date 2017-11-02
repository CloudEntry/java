import java.util.*;
/*
	This program prints a spiral matrix of user defined size and finds the maximum value and its index. 
*/

public class SpiralMatrix {

	//Main method
	public static void main(String [] args) {

		int m, n; //Variables for storing user input rows and columns

		//Take input for number of rows - stored as m
		System.out.println("Input the number of rows:");
		Scanner sm = new Scanner(System.in);
		while(true){ //Validation for value >= 1
			m = sm.nextInt();
			if(m>=1){
				break;
			}
			System.out.println("Input the number of rows:"); 
		}

		//Take input for number of columns - stored as n
		System.out.println("Input the number of columns:");
		Scanner sn = new Scanner(System.in);
		while(true){ //Validation for value >= 1
			n = sn.nextInt();
			if(n>=1){
				break;
			}
			System.out.println("Input the number of columns:");
		}

		//Initiate variables for max value in the matrix, row and column for location of max value
		int maxValue = 0;
        int maxIndexRow = 0;
        int maxIndexCol = 0;

        //Prints the matrix for testing purposes - can delete/comment out if not needed
		for(int[] rows: Matrix(m,n)){ 
        	System.out.println(Arrays.toString(rows));
        }

        //Loop to find the maximum value and find the indexes of the location
		for(int i=0; i<Matrix(m,n).length; i++){

    		for(int j=0; j<Matrix(m,n)[i].length; j++){

        		if(Matrix(m,n)[i][j]>maxValue){

           			maxValue = Matrix(m,n)[i][j];
                	maxIndexRow = i+1;
                	maxIndexCol = j+1;
            	}
        	}
    	}

    	//Prints result to console
    	System.out.println("The largest number would be found in row " + maxIndexRow + ", column " + maxIndexCol);

		}

		//Method for generating the matrix - pass in user input m and n for number of columns and rows
		public static int[][] Matrix(int m, int n){

			int[][] matrix = new int[m][n]; //Declare matrix as 2d array
			String direction = "right"; //direction variable stored as string to know what current direction is
			int maxRotations = m*n; //max number of rotations - product of number of rows and columns of matrix
			int row = 0, col = 0; //Initiate row and column number

			//For loop to populate the matrix
			for(int i=1; i<=maxRotations; i++) {

				//Conditional statements to keep on path of spiral - turns 90 degrees at end of each row/column
	            if(direction=="right" && (col>(n-1) || matrix[row][col]!=0)){ //If going right and at the end of the columns
	                direction = "down"; //Next direction down after right
	                col--;
	                row++;
	            }else if(direction=="down" && (row>(m-1) || matrix[row][col]!=0)){ //If going down and at the bottom of the rows
	                direction = "left"; //Next direction left after down
	                row--;
	                col--;
	            }else if(direction=="left" && (col<0 || matrix[row][col]!=0)){ //If going left and at the other end of the columns
	                direction = "up"; //Next direction up after left
	                col++;
	                row--;
	            }else if(direction=="up" && row<0 || matrix[row][col]!=0){ //If going up and at the top of the rows
	                direction = "right"; //Next direction right after up
	                row++;
	                col++;
	            }

	            matrix[row][col] = i; //Populate current index with i

	            //Conditional statements to increment/decrement column/row number according to direction
	            if(direction=="right"){
	                col++; //If going right - column index increasing
	            }else if(direction=="down"){
	                row++; //If going down - row index increasing
	            }else if(direction=="left"){
	                col--; //If going left - column index decreasing
	            }else if(direction=="up"){
	                row--; //If going up - row index decreasing
	            }
	        }
	        return matrix;
		}
}