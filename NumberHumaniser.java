import java.util.Scanner;

public class NumberHumaniser {

    //Method to deal with ints 1-100
    public String oneToHundred(int n) {
    
        //Instantiate string
        String num = "";
        
        //While n is not 0 print 1 - 19 and the zero n
        while (n != 0) {
            if (n == 1) {
                num = num + "One";
                n = 0;
            } else if (n == 2){
                num = num + "Two";
                n = 0;
            } else if (n == 3){
                num = num + "Three";
                n = 0;
            } else if (n == 4){
                num = num + "Four";
                n = 0;
            } else if (n == 5){
                num = num + "Five";
                n = 0;
            } else if (n == 6){
                num = num + "Six";
                n = 0;
            } else if (n == 7){
                num = num + "Seven";
                n = 0;
            } else if (n == 8){
                num = num + "Eight";
                n = 0;
            } else if (n == 9){
                num = num + "Nine";
                n = 0;
            } else if (n == 10){
                num = num + "Ten";
                n = 0;
            } else if (n == 11){
                num = num + "Eleven";
                n = 0;
            } else if (n == 12){
                num = num + "Twelve";
                n = 0;
            } else if (n == 13){
                num = num + "Thirteen";
                n = 0;
            } else if (n == 14){
                num = num + "Fourteen";
                n = 0;
            } else if (n == 15){
                num = num + "Fifteen";
                n = 0;
            } else if (n == 16){
                num = num + "sixteen";
                n = 0;
            } else if (n == 17){
                num = num + "Seventeen";
                n = 0;
            } else if (n == 18){
                num = num + "Eighteen";
                n = 0;
            } else if (n == 19){
                num = num + "Nineteen";
                n = 0;
                
            //Then do the same for 20 - 90 and then take that much off n
            } else if (n >= 20 && n < 30){
                num = num + "Twenty ";
                n = n - 20;
            } else if (n >= 30 && n < 40){
                num = num + "Thirty ";
                n = n - 30;
            } else if (n >= 40 && n < 50){
                num = num + "Forty ";
                n = n - 40;
            } else if (n >= 50 && n < 60){
                num = num + "Fifty ";
                n = n - 50;
            } else if (n >= 60 && n < 70){
                num = num + "Sixty ";
                n = n - 60;
            } else if (n >= 70 && n < 80){
                num = num + "Seventy ";
                n = n - 70;
            } else if (n >= 80 && n < 90){
                num = num + "Eighty ";
                n = n - 80;
            } else if (n >= 90 && n < 100){
                num = num + "Ninety ";
                n = n - 90;
            }
        }
        
        return num;
    }

    //DO this for all numbers up to 999
    public String humanise(int n) {
        
        String num = "";
        
        //Call one to a hundred method for numbers up to 1000 exclusive and have num before it
        while (n != 0) {
            if (n >= 1 && n < 100){
                num = num + oneToHundred(n);
                n = 0;
            } else if (n >= 100 && n < 1000) {
                num = num + oneToHundred(n/100)+ " ";
                if (n % 100 != 0) {
                    num = num + "Hundred and ";
                }
                else {
                    num = num + "Hundred ";
                }
                //n modulo 100 to deal with remainder
                n = n % 100;
            }
        }
        return num;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String num;
        int n = 1;
        
        NumberHumaniser numberHumaniser = new NumberHumaniser();
        
        //While loop to stop out of range input
        while (n > 0 && n < 1000){
            
            System.out.println("Enter a number between 1 and 999 inclusive (enter 0 to exit)");
            
            //Take user input
            n = scanner.nextInt();
            
            //Call humainse method to display int in words 
            num = numberHumaniser.humanise(n);
            
            System.out.println(num);
        }
    }
}
